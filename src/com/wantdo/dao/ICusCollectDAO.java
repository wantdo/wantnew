package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusCollect;

public interface ICusCollectDAO {
	public List findAll();
	
	public void save(CusCollect cusCollect);
}
