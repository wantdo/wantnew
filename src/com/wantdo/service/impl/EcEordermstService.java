package com.wantdo.service.impl;

import java.util.List;
import java.util.Map;

import com.wantdo.dao.IEcEordermstDAO;
import com.wantdo.domain.EcEordermst;
import com.wantdo.service.IEcEordermstService;

public class EcEordermstService implements IEcEordermstService {
	
	private IEcEordermstDAO ecEordermstDAO;

	@Override
	public void save(EcEordermst transientInstance) {
		// TODO Auto-generated method stub
		ecEordermstDAO.save(transientInstance);
	}

	@Override
	public EcEordermst getById(String id) {
		// TODO Auto-generated method stub
		return ecEordermstDAO.findById(id);
	}

	@Override
	public List getByRelid(Object relid) {
		// TODO Auto-generated method stub
		return ecEordermstDAO.findByRelid(relid);
	}

	@Override
	public List getByMap(Map<String, String> map) {
		// TODO Auto-generated method stub
		return ecEordermstDAO.findByMap(map);
	}
	
	@Override
	public  List getByOrderid(Object orderid){
		return ecEordermstDAO.findByOrderid(orderid);
	}
	

	public IEcEordermstDAO getEcEordermstDAO() {
		return ecEordermstDAO;
	}

	public void setEcEordermstDAO(IEcEordermstDAO ecEordermstDAO) {
		this.ecEordermstDAO = ecEordermstDAO;
	}

	@Override
	public List getAllProblems() {
		// TODO Auto-generated method stub
		return ecEordermstDAO.findAllProblems();
	}

	
	
	

}
