package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusShops;

public interface ICusShopsDAO {

	public abstract void save(CusShops transientInstance);

	public abstract CusShops findById(java.lang.Integer id);

	public abstract List findByShopname(Object shopname);

	public abstract List findByShopmanager(Object shopmanager);

	public abstract List findAll();

}