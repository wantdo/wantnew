package com.wantdo.domain;

/**
 * CusShops entity. @author MyEclipse Persistence Tools
 */

public class CusShops implements java.io.Serializable {

	// Fields

	private Integer id;
	private String shopname;
	private String shopmanager;
	private String shopemail;
	private String shopno;
	private String shopindustry;

	// Constructors

	/** default constructor */
	public CusShops() {
	}

	/** full constructor */
	public CusShops(String shopname, String shopmanager, String shopemail,
			String shopno,String shopindustry) {
		this.shopname = shopname;
		this.shopmanager = shopmanager;
		this.shopemail = shopemail;
		this.shopno = shopno;
		this.shopindustry = shopindustry;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShopmanager() {
		return this.shopmanager;
	}

	public void setShopmanager(String shopmanager) {
		this.shopmanager = shopmanager;
	}

	public String getShopemail() {
		return this.shopemail;
	}

	public void setShopemail(String shopemail) {
		this.shopemail = shopemail;
	}

	public String getShopno() {
		return this.shopno;
	}

	public void setShopno(String shopno) {
		this.shopno = shopno;
	}

	public String getShopindustry() {
		return shopindustry;
	}

	public void setShopindustry(String shopindustry) {
		this.shopindustry = shopindustry;
	}


}