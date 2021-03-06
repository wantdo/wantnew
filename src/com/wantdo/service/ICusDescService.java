package com.wantdo.service;

import com.wantdo.domain.CusDesc;

public interface ICusDescService {
	public abstract CusDesc findById(java.lang.Integer id);
	
	public void update(CusDesc updateInstance);
	
	public void save(CusDesc saveInstance);
	
	public void delete(CusDesc deleteInstance);
}
