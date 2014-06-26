package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusOrderdtl;

public interface ICusOrderdtlDAO {

	public abstract void save(CusOrderdtl transientInstance);

	public abstract List findByCusid(Object cusid);

	public abstract List findAll();

}