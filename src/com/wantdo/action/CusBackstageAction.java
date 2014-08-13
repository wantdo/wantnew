package com.wantdo.action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusCollect;
import com.wantdo.domain.CusLogistics;
import com.wantdo.service.impl.CusCollectService;
import com.wantdo.service.impl.CusLogisticsService;

public class CusBackstageAction extends ActionSupport {
	
	private String variable;
	private CusLogistics cusLogistics;
	private CusCollect cusCollect;
	private CusLogisticsService cusLogisticsService;
	private CusCollectService cusCollectService;
	private List<CusLogistics> logisticsList;
	private List<CusCollect> collectList;
	
	public CusBackstageAction() {
		super();
		logisticsList=new ArrayList<CusLogistics>();
	}
	@Override
	public String execute() throws Exception {
		//System.out.println("*********************");
		System.out.println(variable);
		if(variable.equals("logistics")){
			variable=null;
			logisticsList = cusLogisticsService.findAll();
			return SUCCESS;
		}
		if(variable.equals("logisticsdetail")){
			variable=null;
			logisticsList.clear();
			//System.out.println(cusLogistics);
			System.out.println(cusLogistics.getId());
			cusLogistics = cusLogisticsService.findById(cusLogistics.getId());
			logisticsList.add(getCusLogistics());
			return "logisticsdetail";
		}
		if(variable.equals("backresult")){
			variable=null;
			System.out.println(cusLogistics.getBackresult());
			cusLogisticsService.update(cusLogistics);
			cusCollect.setBackresult(cusLogistics.getBackresult());
			cusCollectService.save(cusCollect);
			return SUCCESS;
		}
		if(variable.equals("cuscollect")){
			variable=null;
			collectList = cusCollectService.findAll();
			return "cuscollect";
		}
		return SUCCESS;
	}
	
	
	public String getVariable() {
		return variable;
	}
	public void setVariable(String variable) {
		this.variable = variable;
	}
	public CusLogistics getCusLogistics() {
		return cusLogistics;
	}
	public void setCusLogistics(CusLogistics cusLogistics) {
		this.cusLogistics = cusLogistics;
	}
	public CusLogisticsService getCusLogisticsService() {
		return cusLogisticsService;
	}
	public void setCusLogisticsService(CusLogisticsService cusLogisticsService) {
		this.cusLogisticsService = cusLogisticsService;
	}
	public List<CusLogistics> getLogisticsList() {
		return logisticsList;
	}
	public void setLogisticsList(List<CusLogistics> logisticsList) {
		this.logisticsList = logisticsList;
	}
	public CusCollect getCusCollect() {
		return cusCollect;
	}
	public void setCusCollect(CusCollect cusCollect) {
		this.cusCollect = cusCollect;
	}
	public CusCollectService getCusCollectService() {
		return cusCollectService;
	}
	public void setCusCollectService(CusCollectService cusCollectService) {
		this.cusCollectService = cusCollectService;
	}
	public List<CusCollect> getCollectList() {
		return collectList;
	}
	public void setCollectList(List<CusCollect> collectList) {
		this.collectList = collectList;
	}
	
}
