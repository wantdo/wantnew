package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.CusCollect;

public interface ICusCollectDAO {
	public List findAll();
	
	public void save(CusCollect cusCollect);
	
	public List queryForPage(final String hql,final int offset,final int length);
	
	public int getAllRowCount(String hql);
}
