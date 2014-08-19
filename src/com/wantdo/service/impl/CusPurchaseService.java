package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusPurchaseDAO;
import com.wantdo.service.ICusPurchaseService;

public class CusPurchaseService implements ICusPurchaseService {
	private ICusPurchaseDAO cusPurchaseDAO;
	@Override
	public List findAll() {
		return cusPurchaseDAO.findAll();
	}
	public ICusPurchaseDAO getCusPurchaseDAO() {
		return cusPurchaseDAO;
	}
	public void setCusPurchaseDAO(ICusPurchaseDAO cusPurchaseDAO) {
		this.cusPurchaseDAO = cusPurchaseDAO;
	}

}
