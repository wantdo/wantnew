package com.wantdo.service;

import java.util.List;
import java.util.Map;

import com.wantdo.domain.EcEordermst;

public interface IEcEordermstService {

	public abstract void save(EcEordermst transientInstance);

	public abstract EcEordermst getById(java.lang.String id);

	public abstract List getByRelid(Object relid);

	public abstract List getByMap(Map<String, String> map);
	
	public abstract List getByOrderid(Object orderid);
	
	public abstract List getAllProblems();

}
