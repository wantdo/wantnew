package com.wantdo.dao;

import java.util.Date;
import java.util.List;

import com.wantdo.domain.CusOrdermst;

public interface ICusOrdermstDAO {

	public abstract void save(CusOrdermst transientInstance);

	public abstract CusOrdermst findById(java.lang.Integer id);

	public abstract List findByWspid(Object wspid);

	public abstract List findByEcid(Object ecid);

	public abstract List findAll();
	
	public abstract List findByOpDate(String startTime,String endTime) throws Exception;

	public List findAllByOpDate(String startTime,String endTime) throws Exception;
	
	public List findShopname();
	
}