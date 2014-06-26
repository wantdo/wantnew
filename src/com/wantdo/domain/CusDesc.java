package com.wantdo.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * CusDesc entity. @author MyEclipse Persistence Tools
 */

public class CusDesc implements java.io.Serializable {

	// Fields

	private Integer id;
	private String description;
	private Set<CusDetail> cusDetails = new HashSet<CusDetail>(0);

	// Constructors

	/** default constructor */
	public CusDesc() {
	}

	/** full constructor */
	public CusDesc(String description, Set<CusDetail> cusDetails) {
		this.description = description;
		this.cusDetails = cusDetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<CusDetail> getCusDetails() {
		return cusDetails;
	}

	public void setCusDetails(Set<CusDetail> cusDetails) {
		this.cusDetails = cusDetails;
	}

	

}