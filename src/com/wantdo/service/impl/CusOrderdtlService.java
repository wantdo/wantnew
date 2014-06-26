package com.wantdo.service.impl;

import java.util.List;

import com.wantdo.dao.ICusOrderdtlDAO;
import com.wantdo.domain.CusOrderdtl;
import com.wantdo.service.ICusOrderdtlService;

public class CusOrderdtlService implements ICusOrderdtlService {
	
	private ICusOrderdtlDAO cusOrderdtlDAO;

	@Override
	public void save(CusOrderdtl transientInstance) {
		// TODO Auto-generated method stub
		cusOrderdtlDAO.save(transientInstance);
	}

	@Override
	public List getByCusid(Object cusid) {
		// TODO Auto-generated method stub
		return cusOrderdtlDAO.findByCusid(cusid);
	}

	@Override
	public List getAll() {
		// TODO Auto-generated method stub
		return cusOrderdtlDAO.findAll();
	}

	public ICusOrderdtlDAO getCusOrderdtlDAO() {
		return cusOrderdtlDAO;
	}

	public void setCusOrderdtlDAO(ICusOrderdtlDAO cusOrderdtlDAO) {
		this.cusOrderdtlDAO = cusOrderdtlDAO;
	}
	
	

}
