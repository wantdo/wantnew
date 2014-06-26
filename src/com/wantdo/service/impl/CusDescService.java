package com.wantdo.service.impl;

import com.wantdo.dao.ICusDescDAO;
import com.wantdo.domain.CusDesc;
import com.wantdo.service.ICusDescService;

public class CusDescService implements ICusDescService {
	private ICusDescDAO cusDescDAO;
	@Override
	public CusDesc findById(Integer id) {
		return cusDescDAO.findById(id);
	}
	@Override
	public void update(CusDesc updateInstance) {
		cusDescDAO.update(updateInstance);
	}
	
	public ICusDescDAO getCusDescDAO() {
		return cusDescDAO;
	}
	public void setCusDescDAO(ICusDescDAO cusDescDAO) {
		this.cusDescDAO = cusDescDAO;
	}
}
