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
	public List findIntact() {
		return cusOrderbackDAO.findIntact();
	}
	@Override
	public List findLogIntact() {
		return cusOrderbackDAO.findLogIntact();
	}
	@Override
	public List findLogHistory() {
		return cusOrderbackDAO.findLogHistory();
	}
	@Override
	public List findPurresult() {
		return cusOrderbackDAO.findPurresult();
	}
	@Override
	public List findBySearch(String search) {
		return cusOrderbackDAO.findBySearch(search);
	}
	@Override
	public List findBySupplier(String search) {
		return cusOrderbackDAO.findBySupplier(search);
	}
	@Override
	public List findByBarcode(String search) {
		return cusOrderbackDAO.findByBarcode(search);
	}
	@Override
	public void save(CusOrderback cusOrderback) {
		cusOrderbackDAO.save(cusOrderback);
	}
	@Override
	public CusOrderback findById(Integer id) {
		return cusOrderbackDAO.findById(id);
	}
	@Override
	public void update(CusOrderback cusOrderback) {
		cusOrderbackDAO.update(cusOrderback);
	}
	
	
	public ICusOrderbackDAO getCusOrderbackDAO() {
		return cusOrderbackDAO;
	}
	public void setCusOrderbackDAO(ICusOrderbackDAO cusOrderbackDAO) {
		this.cusOrderbackDAO = cusOrderbackDAO;
	}
	

}
