package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusPurchaseDAO;
import com.wantdo.domain.CusPurchase;
import com.wantdo.service.ICusPurchaseService;

public class CusPurchaseService implements ICusPurchaseService {
	private ICusPurchaseDAO cusPurchaseDAO;
	@Override
	public List findAll() {
		return cusPurchaseDAO.findAll();
	}
	@Override
	public CusPurchase findById(Integer id) {
		return cusPurchaseDAO.findById(id);
	}
	@Override
	public void save(CusPurchase cusPurchase) {
		cusPurchaseDAO.save(cusPurchase);
	}
	@Override
	public void update(CusPurchase cusPurchase) {
		cusPurchaseDAO.update(cusPurchase);
	}
	
	
	public ICusPurchaseDAO getCusPurchaseDAO() {
		return cusPurchaseDAO;
	}
	public void setCusPurchaseDAO(ICusPurchaseDAO cusPurchaseDAO) {
		this.cusPurchaseDAO = cusPurchaseDAO;
	}

}
