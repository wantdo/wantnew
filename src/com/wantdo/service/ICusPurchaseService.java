package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusPurchase;


public interface ICusPurchaseService {
	public List findAll();
	
	public CusPurchase findById(Integer id);
	
	public void save(CusPurchase cusPurchase);
	
	public void update(CusPurchase cusPurchase);

}
