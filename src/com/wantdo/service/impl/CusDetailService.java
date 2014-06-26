package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusDetailDAO;
import com.wantdo.domain.CusDetail;
import com.wantdo.service.ICusDetailService;


public class CusDetailService implements ICusDetailService {
	
	private ICusDetailDAO cusDetailDAO;

	@Override
	public void save(CusDetail transientInstance) {
		cusDetailDAO.save(transientInstance);
	}
	@Override
	public void delete(CusDetail persistentInstance){
		cusDetailDAO.delete(persistentInstance);
	}

	@Override
	public void update(CusDetail updateInstance){
		cusDetailDAO.update(updateInstance);
	}
	
	@Override
	public List findByExample(CusDetail instance){
		return cusDetailDAO.findByExample(instance);
	}
	
	@Override
	public CusDetail findById(Integer id) {
		return cusDetailDAO.findById(id);
	}
	

	public ICusDetailDAO getCusDetailDAO() {
		return cusDetailDAO;
	}

	public void setCusDetailDAO(ICusDetailDAO cusDetailDAO) {
		this.cusDetailDAO = cusDetailDAO;
	}



}
