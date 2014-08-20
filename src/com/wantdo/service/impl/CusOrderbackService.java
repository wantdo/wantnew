package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusOrderbackDAO;
import com.wantdo.domain.CusOrderback;
import com.wantdo.service.ICusOrderbackService;

public class CusOrderbackService implements ICusOrderbackService {
	private ICusOrderbackDAO cusOrderbackDAO;
	@Override
	public List findAll() {
		return cusOrderbackDAO.findAll();
	}
	@Override
	public void save(CusOrderback cusOrderback) {
		cusOrderbackDAO.save(cusOrderback);
	}
	
	
	public ICusOrderbackDAO getCusOrderbackDAO() {
		return cusOrderbackDAO;
	}
	public void setCusOrderbackDAO(ICusOrderbackDAO cusOrderbackDAO) {
		this.cusOrderbackDAO = cusOrderbackDAO;
	}

}
