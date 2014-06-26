package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusDetail;
import com.wantdo.domain.CusOrderdtl;

public interface ICusDetailDAO {

	public abstract CusDetail findById(java.lang.Integer id);

	public abstract List findByDetail(Object detail);
	
	public abstract void save(CusDetail transientInstance);
	
	public void delete(CusDetail persistentInstance);
	
	public void update(CusDetail updateInstance);
	
	public List findByExample(CusDetail instance);

}