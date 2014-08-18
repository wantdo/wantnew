package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.IWspShopsDAO;
import com.wantdo.dao.impl.WspShopsDAO;
import com.wantdo.domain.WspShops;
import com.wantdo.service.IWspShopsService;
import com.wantdo.utils.PageModel;

public class WspShopsService implements IWspShopsService {
	private IWspShopsDAO wspShopsDAO;
	@Override
	public List findAll() {
		return wspShopsDAO.findAll();
	}
	@Override
	public List findById(Integer wspid) {
		return wspShopsDAO.findById(wspid);
	}
	
	
	
	public IWspShopsDAO getWspShopsDAO() {
		return wspShopsDAO;
	}
	public void setWspShopsDAO(IWspShopsDAO wspShopsDAO) {
		this.wspShopsDAO = wspShopsDAO;
	}

}
