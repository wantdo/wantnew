package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusOrdermst;

public interface ICusOrdermstService {
	
	public abstract void save(CusOrdermst transientInstance);

	public abstract CusOrdermst getById(java.lang.Integer id);

	public abstract List getByWspid(Object wspid);

	public abstract List getByEcid(Object ecid);

	public abstract List getAll();
	
	public abstract List getByOpDate(String startTime,String endTime) throws Exception;

	public List getAllByOpDate(String startTime,String endTime) throws Exception;
	
	public List findShopname();
}
