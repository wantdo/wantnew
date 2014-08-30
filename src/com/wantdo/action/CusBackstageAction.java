package com.wantdo.action;


import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusCollect;
import com.wantdo.domain.CusLogistics;
import com.wantdo.domain.CusPurchase;
import com.wantdo.service.ICusCollectService;
import com.wantdo.service.ICusLogisticsService;
import com.wantdo.service.ICusPurchaseService;
import com.wantdo.utils.PageBean;


//�ͷ�-->�ɹ�or����
public class CusBackstageAction extends ActionSupport {
	
	private String variable;
	private String varpage;
	private CusLogistics cusLogistics;
	private CusPurchase cusPurchase;
	private CusCollect cusCollect;
	private ICusLogisticsService cusLogisticsService;
	private ICusCollectService cusCollectService;
	private ICusPurchaseService cusPurchaseService;
	private List<CusLogistics> logisticsList;
	private List<CusPurchase> purchaseList;
	private List<CusCollect> collectList;
	private String cusRowID;
	private int page;    //�ڼ�ҳ             
	private PageBean pageBean;    //�����ֲ���Ϣ��bean 

	
	public CusBackstageAction() {
		super();
		logisticsList=new ArrayList<CusLogistics>();
		collectList=new ArrayList<CusCollect>();
		purchaseList=new ArrayList<CusPurchase>();
	}
	@Override
	public String execute() throws Exception {
		//System.out.println("*********************");
		System.out.println(variable);
		System.out.println(varpage);
		
		//��ѯ����������Ϣ
		if(variable.equals("purchase")){
			variable=null;
			purchaseList = cusPurchaseService.findAll();
			return "purchase";
		}
		//������������
		if(variable.equals("purchasedetail")){
			variable=null;
			purchaseList.clear();
			System.out.println(cusRowID);
			cusPurchase = cusPurchaseService.findById(Integer.parseInt(cusRowID));
			purchaseList.add(getCusPurchase());
			return "purchasedetail";
		}
		//����ɹ��������
		if(variable.equals("backresultpur")){
			variable=null;
			//System.out.println(cusPurchase.getBackresult());
			cusPurchaseService.update(cusPurchase);
			cusCollect.setBackresult(cusPurchase.getBackresult());
			cusCollectService.save(cusCollect);
			return "purchaseindex";
		}
		
		//��ѯ���пͷ���������Է�������Ϣ
		if(variable.equals("logistics")){
			variable=null;
			logisticsList = cusLogisticsService.findAll();
			return "logistics";
		}
		//��ʾ��Ӧ���Է���������
		if(variable.equals("logisticsdetail")){
			variable=null;
			logisticsList.clear();
			System.out.println(cusRowID);
			cusLogistics = cusLogisticsService.findById(Integer.parseInt(cusRowID));
			logisticsList.add(getCusLogistics());
			return "logisticsdetail";
		}
		//���������������
		if(variable.equals("backresult")){
			variable=null;
			//System.out.println(cusLogistics.getBackresult());
			cusLogisticsService.update(cusLogistics);
			cusCollect.setBackresult(cusLogistics.getBackresult());
			cusCollectService.save(cusCollect);
			return "logisticsindex";
		}
		//�ͷ��˲鿴����������
		if(variable.equals("cuscollectdetail")){
			variable=null;
			//varpage = "cuscollect";
			collectList.clear();
			cusCollect = cusCollectService.findById(Integer.parseInt(cusRowID));
			collectList.add(getCusCollect());
			return "cuscollectdetail";
		}
		//�ͷ��˲鿴����������
		if(varpage.equals("cuscollect")){
			//variable=null;
			//varpage = null;
			collectList = cusCollectService.findAll();
			this.pageBean = cusCollectService.queryForPage(3, page);
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
	public String getVarpage() {
		return varpage;
	}
	public void setVarpage(String varpage) {
		this.varpage = varpage;
	}
	public CusLogistics getCusLogistics() {
		return cusLogistics;
	}
	public void setCusLogistics(CusLogistics cusLogistics) {
		this.cusLogistics = cusLogistics;
	}
	public CusCollect getCusCollect() {
		return cusCollect;
	}
	public void setCusCollect(CusCollect cusCollect) {
		this.cusCollect = cusCollect;
	}
	public ICusLogisticsService getCusLogisticsService() {
		return cusLogisticsService;
	}
	public void setCusLogisticsService(ICusLogisticsService cusLogisticsService) {
		this.cusLogisticsService = cusLogisticsService;
	}
	public ICusCollectService getCusCollectService() {
		return cusCollectService;
	}
	public void setCusCollectService(ICusCollectService cusCollectService) {
		this.cusCollectService = cusCollectService;
	}
	public ICusPurchaseService getCusPurchaseService() {
		return cusPurchaseService;
	}
	public void setCusPurchaseService(ICusPurchaseService cusPurchaseService) {
		this.cusPurchaseService = cusPurchaseService;
	}
	public List<CusLogistics> getLogisticsList() {
		return logisticsList;
	}
	public void setLogisticsList(List<CusLogistics> logisticsList) {
		this.logisticsList = logisticsList;
	}
	public List<CusCollect> getCollectList() {
		return collectList;
	}
	public void setCollectList(List<CusCollect> collectList) {
		this.collectList = collectList;
	}
	public String getCusRowID() {
		return cusRowID;
	}
	public void setCusRowID(String cusRowID) {
		this.cusRowID = cusRowID;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public List<CusPurchase> getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(List<CusPurchase> purchaseList) {
		this.purchaseList = purchaseList;
	}
	public CusPurchase getCusPurchase() {
		return cusPurchase;
	}
	public void setCusPurchase(CusPurchase cusPurchase) {
		this.cusPurchase = cusPurchase;
	}
	
	
}
