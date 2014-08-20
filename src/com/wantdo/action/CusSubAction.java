package com.wantdo.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

	@Override
	public String execute() throws Exception {
		if (cusOrdermst!=null) {
			cusOrdermst.setOperatedate(new Timestamp(new Date().getTime()));
			//new EmailThread().start();
			cusOrdermstService.save(cusOrdermst);
		}else {
			return ERROR;
		}
		if(cusOrdermst.getGoodsendtype().equals("自发")){
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
					cusOrdermst.getGoodsendtype(), null,
					cusOrdermst.getAddress(),cusOrdermst.getImage());
			//cusLogistics.setOperatedate(new Timestamp(new Date().getTime()));
			cusLogisticsService.save(cusLogistics);
		}
		if (cusDtlList!=null) {
			List<CusOrderdtl> nullList=new ArrayList<CusOrderdtl>();
			nullList.add(null);
			cusDtlList.removeAll(nullList);
			for(CusOrderdtl cusOrderdtl:cusDtlList){
				cusOrderdtl.setCusid(cusOrdermst.getCusid());
				cusOrderdtlService.save(cusOrderdtl);
			}
		}else {
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



	/*private final class EmailThread extends Thread{
		

		@Override
		public void run() {
			super.run();
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("cusMst", cusOrdermst);
			map.put("cusDtl", cusDtlList);
			map.put("url", "http://www.wantdo.com");
			String toEmail=cusOrdermst.getShopemail();
			if (cusOrdermst.getDealerflag().equals("自营")) {
				if (cusOrdermst.getSendflg().equals("未配送")) {
					toEmail+=";wdcg01@wantdo.cn;wdcg02@wantdo.cn;wdcg03@wantdo.cn;shenang@wantdo.com";
				}
			}else if (cusOrdermst.getDealerflag().equals("代销")) {
				toEmail+=";wdcg01@wantdo.cn;wdcg02@wantdo.cn;wdcg03@wantdo.cn";
			}
			System.out.println(toEmail);
			Email email=new Email("cm@wantdo.cn", toEmail, 
					"客户反馈", mailService.getMessage(map));
			try {
				mailService.sendMessage(email);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	}*/

	
}
