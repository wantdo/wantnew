package com.wantdo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusDesc;
import com.wantdo.service.IEcEordermstService;

public class CusFeedbackAction extends ActionSupport {
	
	private String orderNo;
	private String telNo;
	private String userName;
	private IEcEordermstService ecEordermstService;
	private List<Object[]> list;
	private List<List<Object[]>> dtlList;
	private List<CusDesc> proList;
	Map<String, String> map;
	
	public CusFeedbackAction() {
		super();
		// TODO Auto-generated constructor stub
		list=new ArrayList<Object[]>();
		map=new HashMap<String, String>();
		dtlList=new ArrayList<List<Object[]>>();
		proList=new ArrayList<CusDesc>();
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if (!orderNo.equals("")) {
			map.put("relid", orderNo);
		}
		if (!telNo.equals("")) {
			map.put("handset", telNo);
		}
		if (!userName.equals("")) {
			map.put("memberid", userName);
		}
		list=ecEordermstService.getByMap(map);
		if (list.size()==0) {
			throw new NullPointerException();
		}
		for(int i=0;i<list.size();++i){
			List<Object[]> oList=new ArrayList<Object[]>();
			oList=ecEordermstService.getByOrderid(list.get(i)[2]);
			dtlList.add(oList);
		}
		proList=ecEordermstService.getAllProblems();
		System.out.println(proList);
		return SUCCESS;
	}


	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public IEcEordermstService getEcEordermstService() {
		return ecEordermstService;
	}

	public void setEcEordermstService(IEcEordermstService ecEordermstService) {
		this.ecEordermstService = ecEordermstService;
	}

	public List<Object[]> getList() {
		return list;
	}

	public void setList(List<Object[]> list) {
		this.list = list;
	}

	public List<List<Object[]>> getDtlList() {
		return dtlList;
	}

	public void setDtlList(List<List<Object[]>> dtlList) {
		this.dtlList = dtlList;
	}

	public List<CusDesc> getProList() {
		return proList;
	}

	public void setProList(List<CusDesc> proList) {
		this.proList = proList;
	}
	
	
	

}
