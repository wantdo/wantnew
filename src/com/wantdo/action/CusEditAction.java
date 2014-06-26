package com.wantdo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusDesc;
import com.wantdo.domain.CusDetail;
import com.wantdo.domain.Person;
import com.wantdo.service.ICusDescService;
import com.wantdo.service.ICusDetailService;
import com.wantdo.service.IEcEordermstService;
import com.wantdo.service.IPersonService;
import com.wantdo.service.impl.CusDetailService;

public class CusEditAction extends ActionSupport {
	
	private String edit;
	private ICusDetailService cusDetailService;
	private CusDetail cusDetail;
	private ICusDescService cusDescService;
	private CusDesc cusDesc;
	private List<CusDesc> proList;
	private IEcEordermstService ecEordermstService;
	private List<CusDetail> updateList;
	private List<CusDesc> updateDesc;
	
	public CusEditAction() {
		super();
		proList=new ArrayList<CusDesc>();
		updateList = new ArrayList<CusDetail>();
		updateDesc = new ArrayList<CusDesc>();
	}
	@Override
	public String execute() throws Exception {
		//System.out.println("*********************");
		//System.out.println(edit);
		proList=ecEordermstService.getAllProblems();
		if(edit == null){
			return "login";
		}
		if(edit.equals("add")){
			return "add";
		}
		if(edit.equals("addimpl") && cusDetail != null){
			//System.out.println(cusDetail.getDetail());
			//System.out.println(cusDetail.getCusDesc().getId());
			cusDetailService.save(cusDetail);
		}
		if(edit.equals("delete")){
			//System.out.println(cusDetail.getId());
			cusDetailService.delete(cusDetail);
		}
		if(edit.equals("update") && cusDetail != null){
			cusDetail = cusDetailService.findById(cusDetail.getId());
			updateList.add(getCusDetail());
			//System.out.println(updateList.size());
			return "update";
		}
		if(edit.equals("update") && cusDesc != null){
			cusDesc = cusDescService.findById(cusDesc.getId());
			updateDesc.add(getCusDesc());
			return "update";
		}
		if(edit.equals("updateimpl") && cusDetail != null){
			cusDetailService.update(cusDetail);
		}
		if(edit.equals("updateimpl") && cusDesc != null){
			cusDescService.update(cusDesc);
		}
		return "wait";
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public List<CusDesc> getProList() {
		return proList;
	}

	public void setProList(List<CusDesc> proList) {
		this.proList = proList;
	}

	public IEcEordermstService getEcEordermstService() {
		return ecEordermstService;
	}

	public void setEcEordermstService(IEcEordermstService ecEordermstService) {
		this.ecEordermstService = ecEordermstService;
	}
	public ICusDetailService getCusDetailService() {
		return cusDetailService;
	}
	public void setCusDetailService(ICusDetailService cusDetailService) {
		this.cusDetailService = cusDetailService;
	}
	public CusDetail getCusDetail() {
		return cusDetail;
	}
	public void setCusDetail(CusDetail cusDetail) {
		this.cusDetail = cusDetail;
	}
	public List<CusDetail> getUpdateList() {
		return updateList;
	}
	public void setUpdateList(List<CusDetail> updateList) {
		this.updateList = updateList;
	}
	public CusDesc getCusDesc() {
		return cusDesc;
	}
	public void setCusDesc(CusDesc cusDesc) {
		this.cusDesc = cusDesc;
	}
	public ICusDescService getCusDescService() {
		return cusDescService;
	}
	public void setCusDescService(ICusDescService cusDescService) {
		this.cusDescService = cusDescService;
	}
	public List<CusDesc> getUpdateDesc() {
		return updateDesc;
	}
	public void setUpdateDesc(List<CusDesc> updateDesc) {
		this.updateDesc = updateDesc;
	}


}
