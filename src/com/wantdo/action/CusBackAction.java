package com.wantdo.action;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.utils.ExcelUtil;


//采购-->物流
public class CusBackAction extends ActionSupport {
	
	private String variable;
	private File temp;
	private File upload;
	private String uploadFileName;
	
	public CusBackAction() {
		super();
	}
	@Override
	public String execute() throws Exception {
		//System.out.println("*********************");
		System.out.println(variable);
		if(variable.equals("purchase")){
			variable = null;
			return SUCCESS;
		}
		if(variable.equals("upload")){
			variable = null;
			//解析上传Excel文件
			InputStream in=null;
			OutputStream out=null;
			try {
				System.out.println(upload);
				String uploadDir=ServletActionContext.getServletContext().getRealPath("/")+"upload";
				System.out.println(uploadFileName);
				if (!(new File(uploadDir).isDirectory())) {
					new File(uploadDir).mkdirs();
					uploadDir=ServletActionContext.getServletContext().getRealPath("upload");
				}
				temp=new File(uploadDir+File.separator+uploadFileName);
				if (!temp.exists()) {
					temp.createNewFile();
				}
				in=new BufferedInputStream(new FileInputStream(upload));
				out=new FileOutputStream(temp);
				byte[] b=new byte[1024];
				int len=0;
				while ((len=in.read(b))!=-1) {
					out.write(b,0,len);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					if (out!=null) {
						out.close();
					}
					if (in!=null) {
						in.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ExcelUtil excelUtil=null;
			try {
				excelUtil = new ExcelUtil(new BufferedInputStream(new FileInputStream(temp)));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			excelUtil.getAllData(1);
			return "wait";
		}
		
		return SUCCESS;
	}
	
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public File getTemp() {
		return temp;
	}
	public void setTemp(File temp) {
		this.temp = temp;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
}
