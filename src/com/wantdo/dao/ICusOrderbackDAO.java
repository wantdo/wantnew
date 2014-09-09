package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusOrderback;

public interface ICusOrderbackDAO {
	public List findAll();
	
	public List findIntact();
	
	public List findLogIntact();
	
	public List findLogHistory();
	
	public List findPurresult();
	
	public List findBySearch(String search);
	
	public void save(CusOrderback cusOrderback);
	
	public CusOrderback findById(Integer id);
	
	public void update(CusOrderback cusOrderback);
}
