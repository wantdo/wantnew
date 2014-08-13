package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusLogisticsDAO;
import com.wantdo.domain.CusLogistics;
import com.wantdo.service.ICusLogisticsService;

public class CusLogisticsService implements ICusLogisticsService {
	
	private ICusLogisticsDAO cusLogisticsDAO;
	
	@Override
	public List findAll() {
		return cusLogisticsDAO.findAll();
	}
	@Override
	public void save(CusLogistics cusLogistics) {
		cusLogisticsDAO.save(cusLogistics);
	}
	@Override
	public CusLogistics findById(Integer id) {
		return cusLogisticsDAO.findById(id);
	}
	@Override
	public void update(CusLogistics cusLogistics) {
		cusLogisticsDAO.update(cusLogistics);
	}

	public ICusLogisticsDAO getCusLogisticsDAO() {
		return cusLogisticsDAO;
	}

	public void setCusLogisticsDAO(ICusLogisticsDAO cusLogisticsDAO) {
		this.cusLogisticsDAO = cusLogisticsDAO;
	}


}
