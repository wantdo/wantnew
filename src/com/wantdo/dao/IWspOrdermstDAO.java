package com.wantdo.dao;

import java.util.List;
import java.util.Map;

import com.wantdo.domain.WspOrdermst;

public interface IWspOrdermstDAO {
	
	 public WspOrdermst findById(String id);

	public abstract List findByRelid(Object relid);

}