package com.wantdo.domain;

/**
 * CusOrderdtl entity. @author MyEclipse Persistence Tools
 */

public class CusOrderdtl implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer cusid;
	private String proname;
	private String prospecification;
	private String proqty;
	private String itemno;

	// Constructors

	/** default constructor */
	public CusOrderdtl() {
	}

	/** full constructor */
	public CusOrderdtl(Integer cusid, String proname, String prospecification,
			String proqty, String itemno) {
		this.cusid = cusid;
		this.proname = proname;
		this.prospecification = prospecification;
		this.proqty = proqty;
		this.itemno = itemno;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCusid() {
		return this.cusid;
	}

	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}

	public String getProname() {
		return this.proname;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public String getProspecification() {
		return this.prospecification;
	}

	public void setProspecification(String prospecification) {
		this.prospecification = prospecification;
	}

	public String getProqty() {
		return this.proqty;
	}

	public void setProqty(String proqty) {
		this.proqty = proqty;
	}

	public String getItemno() {
		return this.itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

}