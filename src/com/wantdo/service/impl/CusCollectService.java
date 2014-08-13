package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusCollectDAO;
import com.wantdo.dao.impl.CusCollectDAO;
import com.wantdo.domain.CusCollect;
import com.wantdo.service.ICusCollectService;


public class CusCollectService implements ICusCollectService {
	private ICusCollectDAO cusCollectDAO;
	@Override
	public List findAll() {
		return cusCollectDAO.findAll();
	}
	@Override
	public void save(CusCollect cusCollect) {
		cusCollectDAO.save(cusCollect);
	}
	
	
	
	public ICusCollectDAO getCusCollectDAO() {
		return cusCollectDAO;
	}
	public void setCusCollectDAO(ICusCollectDAO cusCollectDAO) {
		this.cusCollectDAO = cusCollectDAO;
	}

}
