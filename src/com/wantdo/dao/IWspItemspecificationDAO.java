package com.wantdo.dao;

import com.wantdo.domain.WspItemspecification;

public interface IWspItemspecificationDAO {

	public abstract void save(WspItemspecification transientInstance);

	public abstract WspItemspecification findById(java.lang.String id);

}