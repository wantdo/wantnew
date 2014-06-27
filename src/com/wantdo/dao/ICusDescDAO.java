package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusDesc;

public interface ICusDescDAO {

	public abstract CusDesc findById(java.lang.Integer id);

	public abstract List findByDescription(Object description);

	public void update(CusDesc updateInstance);
	
	public void save(CusDesc saveInstance);
	
	public void delete(CusDesc deleteInstance);

}