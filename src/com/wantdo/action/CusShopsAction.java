package com.wantdo.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.wantdo.domain.CusShops;
import com.wantdo.domain.WspShops;
import com.wantdo.service.ICusShopsService;
import com.wantdo.service.IWspShopsService;

public class CusShopsAction extends ActionSupport {
	
	private String edit;
	private ICusShopsService cusShopsService;
	private IWspShopsService wspShopsService;
	private CusShops cusShops;
	private WspShops wspShops;
	private List<CusShops> cusList;
	private List<CusShops> tempList;
	private List<Object[]> updateList;
	private List<WspShops> wspList;
	
	public CusShopsAction() {
		super();
		cusList=new ArrayList<CusShops>();
		tempList=new ArrayList<CusShops>();
		updateList=new ArrayList<Object[]>();
		wspList=new ArrayList<WspShops>();
	}
	@Override
	public String execute() throws Exception {
		//System.out.println("*********************");
		//System.out.println(edit);
		//cusList=cusShopsService.findAll();
		wspList=wspShopsService.findAll();
		
		if(edit == null){
			return SUCCESS;
		}
		/*if(edit.equals("add")){
			edit = null;
			return "add";
		}*/
		if(edit.equals("addimpl") && cusShops != null ){
			edit = null;
			//System.out.println(cusShops.getWspshopid());
			cusShopsService.save(cusShops);
			return "wait";
		}
		if(edit.equals("delete") && cusShops != null){
			edit = null;
			//cusShopsService.delete(cusShops);
			return "wait";
		}
		if(edit.equals("update") && wspShops != null){
			edit = null;
			updateList.clear();
			updateList = wspShopsService.findById(wspShops.getId());
			Object[] o = updateList.get(0);
			if(o[3] == null){
				return "add";
			}
			return "update";
		}
		if(edit.equals("updateimpl") && cusShops != null){
			edit = null;
			cusShopsService.update(cusShops);
			return "wait";
		}
		return SUCCESS;
	}
	
	
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	public ICusShopsService getCusShopsService() {
		return cusShopsService;
	}
	public void setCusShopsService(ICusShopsService cusShopsService) {
		this.cusShopsService = cusShopsService;
	}
	public IWspShopsService getWspShopsService() {
		return wspShopsService;
	}
	public void setWspShopsService(IWspShopsService wspShopsService) {
		this.wspShopsService = wspShopsService;
	}
	public CusShops getCusShops() {
		return cusShops;
	}
	public void setCusShops(CusShops cusShops) {
		this.cusShops = cusShops;
	}
	public WspShops getWspShops() {
		return wspShops;
	}
	public void setWspShops(WspShops wspShops) {
		this.wspShops = wspShops;
	}
	public List<CusShops> getCusList() {
		return cusList;
	}
	public void setCusList(List<CusShops> cusList) {
		this.cusList = cusList;
	}
	public List<Object[]> getUpdateList() {
		return updateList;
	}
	public void setUpdateList(List<Object[]> updateList) {
		this.updateList = updateList;
	}
	public List<WspShops> getWspList() {
		return wspList;
	}
	public void setWspList(List<WspShops> wspList) {
		this.wspList = wspList;
	}


}
