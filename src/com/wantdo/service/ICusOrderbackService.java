package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusOrderback;

public interface ICusOrderbackService {
	public List findAll();
	
	public List findIntact();
	
	public List findLogIntact();
	
	public List findLogHistory();
	
	public List findPurresult();
	
	public List findStatus();
	
	public List findBySearch(String search);
	
	public List findBySupplier(String search);
	
	public List findByBarcode(String search);
	
	public void save(CusOrderback cusOrderback);
	
	public CusOrderback findById(Integer id);
	
	public void update(CusOrderback cusOrderback);
}
