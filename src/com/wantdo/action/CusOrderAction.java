package com.wantdo.action;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
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


//采购-->物流
public class CusOrderAction extends ActionSupport {
	
	private List<CusOrderback> orderList;
	private ICusOrderbackService cusOrderbackService;
	private File tempimg;
	private File imgwuliu;
	private String imgwuliuFileName;
	private String imgpath;
	private CusOrderback cusOrderback;
	
	public CusOrderAction() {
		super();
		orderList = new ArrayList<CusOrderback>();
	}
	@Override
	public String execute() throws Exception {
		orderList.clear();
		InputStream in=null;
		OutputStream out=null;
		//上传图片
		try {
			String uploadDir=ServletActionContext.getServletContext().getRealPath("/")+"uploadimg";
			if (!(new File(uploadDir).isDirectory())) {
				new File(uploadDir).mkdirs();
				uploadDir=ServletActionContext.getServletContext().getRealPath("uploadimg");
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
			 
			imgwuliuFileName = sdf.format(new Date())+imgwuliuFileName;
			tempimg=new File(uploadDir+File.separator+imgwuliuFileName);
			if (!tempimg.exists()) {
				tempimg.createNewFile();
			}
			imgpath = "uploadimg/" + imgwuliuFileName;
			in=new BufferedInputStream(new FileInputStream(imgwuliu));
			out=new FileOutputStream(tempimg);
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
		cusOrderback.setArrivaltime(new Date());
		//cusOrderback.setImgorder(imgpath);
		cusOrderbackService.update(cusOrderback);
		orderList = cusOrderbackService.findAll();
		return "orderlist";
	}
	
	
	public List<CusOrderback> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<CusOrderback> orderList) {
		this.orderList = orderList;
	}
	public ICusOrderbackService getCusOrderbackService() {
		return cusOrderbackService;
	}
	public void setCusOrderbackService(ICusOrderbackService cusOrderbackService) {
		this.cusOrderbackService = cusOrderbackService;
	}
	public File getTempimg() {
		return tempimg;
	}
	public void setTempimg(File tempimg) {
		this.tempimg = tempimg;
	}
	public File getImgwuliu() {
		return imgwuliu;
	}
	public void setImgwuliu(File imgwuliu) {
		this.imgwuliu = imgwuliu;
	}
	public String getImgwuliuFileName() {
		return imgwuliuFileName;
	}
	public void setImgwuliuFileName(String imgwuliuFileName) {
		this.imgwuliuFileName = imgwuliuFileName;
	}
	public String getImgpath() {
		return imgpath;
	}
	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}
	public CusOrderback getCusOrderback() {
		return cusOrderback;
	}
	public void setCusOrderback(CusOrderback cusOrderback) {
		this.cusOrderback = cusOrderback;
	}
	
}
