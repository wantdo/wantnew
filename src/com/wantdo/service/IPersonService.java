package com.wantdo.service;

import java.util.List;

import com.wantdo.domain.Person;

public interface IPersonService {
	
	public abstract void save(Person transientInstance);

	public abstract Person getById(java.lang.Integer id);

	public abstract List getByUsername(Object username);

	public abstract List getAll();
	
	public abstract boolean checkLogin(Person person);

}
