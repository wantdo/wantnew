package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusOrdermstDAO;
import com.wantdo.domain.CusOrdermst;
import com.wantdo.service.ICusOrdermstService;

public class CusOrdermstService implements ICusOrdermstService {
	
	private ICusOrdermstDAO cusOrdermstDAO;

	@Override
	public void save(CusOrdermst transientInstance) {
		// TODO Auto-generated method stub
		cusOrdermstDAO.save(transientInstance);
	}

	@Override
	public CusOrdermst getById(Integer id) {
		// TODO Auto-generated method stub
		return cusOrdermstDAO.findById(id);
	}

	@Override
	public List getByWspid(Object wspid) {
		// TODO Auto-generated method stub
		return cusOrdermstDAO.findByWspid(wspid);
	}

	@Override
	public List getByEcid(Object ecid) {
		// TODO Auto-generated method stub
		return cusOrdermstDAO.findByEcid(ecid);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public ICusOrdermstDAO getCusOrdermstDAO() {
		return cusOrdermstDAO;
	}

	public void setCusOrdermstDAO(ICusOrdermstDAO cusOrdermstDAO) {
		this.cusOrdermstDAO = cusOrdermstDAO;
	}

	@Override
	public List getByOpDate(String startTime, String endTime) throws Exception {
		// TODO Auto-generated method stub
		return cusOrdermstDAO.findByOpDate(startTime, endTime);
	}

	@Override
	public List getAllByOpDate(String startTime, String endTime)
			throws Exception {
		// TODO Auto-generated method stub
		return cusOrdermstDAO.findAllByOpDate(startTime, endTime);
	}

	@Override
	public List findShopname() {
		// TODO Auto-generated method stub
		return cusOrdermstDAO.findShopname();
	}
	
}
