package com.wantdo.dao;

import java.util.List;
import java.util.Map;

import com.wantdo.domain.EcEordermst;

public interface IEcEordermstDAO {

	public abstract void save(EcEordermst transientInstance);

	public abstract EcEordermst findById(java.lang.String id);

	public abstract List findByRelid(Object relid);

	public abstract List findByMap(Map<String, String> map);
	
	public abstract List findByOrderid(Object orderid);
	
	public abstract List findAllProblems();

}