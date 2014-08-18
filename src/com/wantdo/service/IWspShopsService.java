package com.wantdo.service;

import java.util.List;

import com.wantdo.utils.PageModel;

public interface IWspShopsService {
	//查询所有ERP店铺名及其关联的wantdo店铺信息
	public List findAll();
	//查询指定ID的ERP店铺名及其关联的wantdo店铺信息
	public List findById(Integer wspid);
	
}
