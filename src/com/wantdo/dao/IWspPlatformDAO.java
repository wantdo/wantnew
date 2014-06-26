package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.WspPlatform;

public interface IWspPlatformDAO {

	public abstract void save(WspPlatform transientInstance);

	public abstract WspPlatform findById(java.lang.Integer id);

	public abstract List findBySystemname(Object systemname);

}