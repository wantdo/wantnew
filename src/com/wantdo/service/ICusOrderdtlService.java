package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusOrderdtl;

public interface ICusOrderdtlService {
	
	public abstract void save(CusOrderdtl transientInstance);

	public abstract List getByCusid(Object cusid);

	public abstract List getAll();


}
