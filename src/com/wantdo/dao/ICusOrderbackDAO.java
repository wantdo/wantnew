package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusOrderback;

public interface ICusOrderbackDAO {
	public List findAll();
	
	public void save(CusOrderback cusOrderback);
}
