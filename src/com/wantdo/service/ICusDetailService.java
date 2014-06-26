package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusDetail;


public interface ICusDetailService {
	
	public void save(CusDetail transientInstance);
	
	public void delete(CusDetail persistentInstance);
	
	public void update(CusDetail updateInstance);
	
	public List findByExample(CusDetail instance);
	
	public abstract CusDetail findById(java.lang.Integer id);

	//public abstract List getByCusid(Object cusid);

	//public abstract List getAll();


}
