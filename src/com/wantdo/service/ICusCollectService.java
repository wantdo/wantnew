package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusCollect;

public interface ICusCollectService {
	public List findAll();
	
	public void save(CusCollect cusCollect);
}
