package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusPurchase;

public interface ICusPurchaseDAO {
	public List findAll();
	
	public void save(CusPurchase cusPurchase);
	
	public void update(CusPurchase cusPurchase);
	
	public CusPurchase findById(Integer id);
}
