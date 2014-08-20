package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusOrderback;

public interface ICusOrderbackService {
	public List findAll();
	
	public void save(CusOrderback cusOrderback);
}
