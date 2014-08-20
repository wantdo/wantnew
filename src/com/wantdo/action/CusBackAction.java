package com.wantdo.action;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusOrderback;
import com.wantdo.service.ICusOrderbackService;
import com.wantdo.utils.ExcelUtil;


//采购-->物流
public class CusBackAction extends ActionSupport {
	
	private String variable;
	private File temp;
	private File upload;
	private String uploadFileName;
	private List<String> list;
	private CusOrderback cusOrderback;
	private ICusOrderbackService cusOrderbackService;
	private SimpleDateFormat sdf;
	
	public CusBackAction() {
		super();
		list = new ArrayList<String>();
		sdf = new SimpleDateFormat("yyyy_MM_dd");
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
				System.out.println(uploadDir);
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
			List<String[]> list = excelUtil.getAllData(1);
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(list.get(2)[0]);
			for(int i = 2;i < list.size();i++){
				CusOrderback cusOrderback = new CusOrderback();
				cusOrderback.setOrderdate(sdf.parse(list.get(i)[0]));
				cusOrderback.setPurid(list.get(i)[1]);
				cusOrderback.setSupplier(list.get(i)[2]);
				cusOrderback.setGoodsname(list.get(i)[3]);
				cusOrderback.setBarcode(list.get(i)[4]);
				cusOrderback.setGoodsid(list.get(i)[5]);
				cusOrderback.setGoodsproperty(list.get(i)[6]);
				cusOrderback.setNum(list.get(i)[7]);
				cusOrderback.setPrice(list.get(i)[8]);
				cusOrderback.setFare(list.get(i)[9]);
				cusOrderback.setTotal(list.get(i)[10]);
				cusOrderback.setRemark1(list.get(i)[11]);
				cusOrderback.setExpress(list.get(i)[12]);
				cusOrderback.setWaybill(list.get(i)[13]);
				cusOrderback.setArrivalnum(list.get(i)[14]);
				cusOrderback.setMistake(list.get(i)[15]);
				cusOrderback.setCondition(list.get(i)[16]);
				cusOrderback.setArrivaltime(sdf.parse(list.get(i)[17]));
				cusOrderback.setOpenman(list.get(i)[18]);
				cusOrderback.setSignman(list.get(i)[19]);
				cusOrderback.setRemark2(list.get(i)[20]);
				cusOrderbackService.save(cusOrderback);
			}
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
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public ICusOrderbackService getCusOrderbackService() {
		return cusOrderbackService;
	}
	public void setCusOrderbackService(ICusOrderbackService cusOrderbackService) {
		this.cusOrderbackService = cusOrderbackService;
	}
	public CusOrderback getCusOrderback() {
		return cusOrderback;
	}
	public void setCusOrderback(CusOrderback cusOrderback) {
		this.cusOrderback = cusOrderback;
	}
	
}
