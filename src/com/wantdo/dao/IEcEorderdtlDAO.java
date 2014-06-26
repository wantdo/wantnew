package com.wantdo.dao;

import java.util.List;

import com.wantdo.domain.EcEorderdtl;

public interface IEcEorderdtlDAO {

	public abstract void save(EcEorderdtl transientInstance);

	public abstract List findBySkuid(Object skuid);
}