package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.CusCollect;
import com.wantdo.utils.PageBean;

public interface ICusCollectService {
	public List findAll();
	
	public void save(CusCollect cusCollect);
	
	public PageBean queryForPage(int pageSize,int currentPage); 
}
