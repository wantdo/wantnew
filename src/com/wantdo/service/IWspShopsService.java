package com.wantdo.service;

import java.util.List;

import com.wantdo.utils.PageModel;

public interface IWspShopsService {
	//��ѯ����ERP���������������wantdo������Ϣ
	public List findAll();
	//��ѯָ��ID��ERP���������������wantdo������Ϣ
	public List findById(Integer wspid);
	
}
