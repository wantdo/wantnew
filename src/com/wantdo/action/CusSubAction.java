package com.wantdo.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusLogistics;
import com.wantdo.domain.CusOrderdtl;
import com.wantdo.domain.CusOrdermst;
import com.wantdo.service.ICusLogisticsService;
import com.wantdo.service.ICusOrderdtlService;
import com.wantdo.service.ICusOrdermstService;
import com.wantdo.service.impl.MailService;

public class CusSubAction extends ActionSupport {

	private CusOrdermst cusOrdermst;
	private CusLogistics cusLogistics;
	private ICusLogisticsService cusLogisticsService;
	private ICusOrdermstService cusOrdermstService;
	private ICusOrderdtlService cusOrderdtlService;
	private List<CusOrderdtl> cusDtlList;
	private MailService mailService;
	private String variable;
	private File temp;
	private File imgkefu;
	private String imgkefuFileName;
	private String imgpath;

	@Override
	public String execute() throws Exception {
		if(variable.equals("upload")){
			variable = null;
			InputStream in=null;
			OutputStream out=null;
			try {
				String uploadDir=ServletActionContext.getServletContext().getRealPath("/")+"uploadimg";
				if (!(new File(uploadDir).isDirectory())) {
					new File(uploadDir).mkdirs();
					uploadDir=ServletActionContext.getServletContext().getRealPath("uploadimg");
				}
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); 
				 
				imgkefuFileName = sdf.format(new Date())+imgkefuFileName;
				temp=new File(uploadDir+File.separator+imgkefuFileName);
				if (!temp.exists()) {
					temp.createNewFile();
				}
				imgpath = "uploadimg/" + imgkefuFileName;
				in=new BufferedInputStream(new FileInputStream(imgkefu));
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
		}
		
		if (cusOrdermst != null) {
			cusOrdermst.setOperatedate(new Timestamp(new Date().getTime()));
			// new EmailThread().start();
			cusOrdermstService.save(cusOrdermst);
		} else {
			return ERROR;
		}
		if (cusOrdermst.getGoodsendtype().equals("自发")) {
			CusLogistics cusLogistics = new CusLogistics(
					cusOrdermst.getWaybill(), cusOrdermst.getLinkman(),
					cusOrdermst.getHandset(), cusOrdermst.getRecaddr(),
					cusOrdermst.getEcid(), cusOrdermst.getSysname(),
					cusOrdermst.getShopname(), cusOrdermst.getOrderdate(),
					cusOrdermst.getOperatedate(), cusOrdermst.getCusdesc(),
					cusOrdermst.getCusdetail(),
					cusOrdermst.getOperateopinion(),
					cusOrdermst.getOperateman(),
					cusOrdermst.getOperateremark(), cusOrdermst.getRelid(),
					cusOrdermst.getGoodsendtype(), null,cusOrdermst.getAddress(),imgpath);
			cusLogisticsService.save(cusLogistics);
		}
		if (cusDtlList != null) {
			List<CusOrderdtl> nullList = new ArrayList<CusOrderdtl>();
			nullList.add(null);
			cusDtlList.removeAll(nullList);
			for (CusOrderdtl cusOrderdtl : cusDtlList) {
				cusOrderdtl.setCusid(cusOrdermst.getCusid());
				cusOrderdtlService.save(cusOrderdtl);
			}
		} else {
			return ERROR;
		}
		return SUCCESS;
	}



	public ICusOrdermstService getCusOrdermstService() {
		return cusOrdermstService;
	}

	public void setCusOrdermstService(ICusOrdermstService cusOrdermstService) {
		this.cusOrdermstService = cusOrdermstService;
	}

	public ICusOrderdtlService getCusOrderdtlService() {
		return cusOrderdtlService;
	}

	public void setCusOrderdtlService(ICusOrderdtlService cusOrderdtlService) {
		this.cusOrderdtlService = cusOrderdtlService;
	}

	public List<CusOrderdtl> getCusDtlList() {
		return cusDtlList;
	}

	public void setCusDtlList(List<CusOrderdtl> cusDtlList) {
		this.cusDtlList = cusDtlList;
	}

	public CusOrdermst getCusOrdermst() {
		return cusOrdermst;
	}

	public void setCusOrdermst(CusOrdermst cusOrdermst) {
		this.cusOrdermst = cusOrdermst;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	public ICusLogisticsService getCusLogisticsService() {
		return cusLogisticsService;
	}

	public void setCusLogisticsService(ICusLogisticsService cusLogisticsService) {
		this.cusLogisticsService = cusLogisticsService;
	}

	public CusLogistics getCusLogistics() {
		return cusLogistics;
	}

	public void setCusLogistics(CusLogistics cusLogistics) {
		this.cusLogistics = cusLogistics;
	}


	public File getTemp() {
		return temp;
	}

	public String getVariable() {
		return variable;
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public void setTemp(File temp) {
		this.temp = temp;
	}


	public File getImgkefu() {
		return imgkefu;
	}



	public void setImgkefu(File imgkefu) {
		this.imgkefu = imgkefu;
	}



	public String getImgpath() {
		return imgpath;
	}



	public void setImgpath(String imgpath) {
		this.imgpath = imgpath;
	}



	public String getImgkefuFileName() {
		return imgkefuFileName;
	}



	public void setImgkefuFileName(String imgkefuFileName) {
		this.imgkefuFileName = imgkefuFileName;
	}



	/*
	 * private final class EmailThread extends Thread{
	 * 
	 * 
	 * @Override public void run() { super.run(); Map<String, Object> map=new
	 * HashMap<String, Object>(); map.put("cusMst", cusOrdermst);
	 * map.put("cusDtl", cusDtlList); map.put("url", "http://www.wantdo.com");
	 * String toEmail=cusOrdermst.getShopemail(); if
	 * (cusOrdermst.getDealerflag().equals("自营")) { if
	 * (cusOrdermst.getSendflg().equals("未配送")) { toEmail+=
	 * ";wdcg01@wantdo.cn;wdcg02@wantdo.cn;wdcg03@wantdo.cn;shenang@wantdo.com";
	 * } }else if (cusOrdermst.getDealerflag().equals("代销")) {
	 * toEmail+=";wdcg01@wantdo.cn;wdcg02@wantdo.cn;wdcg03@wantdo.cn"; }
	 * System.out.println(toEmail); Email email=new Email("cm@wantdo.cn",
	 * toEmail, "客户反馈", mailService.getMessage(map)); try {
	 * mailService.sendMessage(email); } catch (MessagingException e) {
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */

}
