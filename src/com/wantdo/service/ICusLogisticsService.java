package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusLogistics;


public interface ICusLogisticsService {
	
	public List findAll();
	
	public CusLogistics findById(Integer id);
	
	public void save(CusLogistics cusLogistics);
	
	public void update(CusLogistics cusLogistics);


}
