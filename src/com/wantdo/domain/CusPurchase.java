package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * CusPurchase entity. @author MyEclipse Persistence Tools
 */

public class CusPurchase implements java.io.Serializable {

	// Fields

	private Integer id;
	private String waybill;
	private String linkman;
	private String handset;
	private String recaddr;
	private String ecid;
	private String sysname;
	private String shopname;
	private Timestamp orderdate;
	private Timestamp operatedate;
	private String cusdesc;
	private String cusdetail;
	private String operateopinion;
	private String operateman;
	private String operateremark;
	private String relid;
	private String goodsendtype;
	private String backresult;
	private String image;

	// Constructors

	/** default constructor */
	public CusPurchase() {
	}

	/** full constructor */
	public CusPurchase(String waybill, String linkman, String handset,
			String recaddr, String ecid, String sysname, String shopname,
			Timestamp orderdate, Timestamp operatedate, String cusdesc,
			String cusdetail, String operateopinion, String operateman,
			String operateremark, String relid, String goodsendtype,
			String backresult, String image) {
		this.waybill = waybill;
		this.linkman = linkman;
		this.handset = handset;
		this.recaddr = recaddr;
		this.ecid = ecid;
		this.sysname = sysname;
		this.shopname = shopname;
		this.orderdate = orderdate;
		this.operatedate = operatedate;
		this.cusdesc = cusdesc;
		this.cusdetail = cusdetail;
		this.operateopinion = operateopinion;
		this.operateman = operateman;
		this.operateremark = operateremark;
		this.relid = relid;
		this.goodsendtype = goodsendtype;
		this.backresult = backresult;
		this.image = image;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWaybill() {
		return this.waybill;
	}

	public void setWaybill(String waybill) {
		this.waybill = waybill;
	}

	public String getLinkman() {
		return this.linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getHandset() {
		return this.handset;
	}

	public void setHandset(String handset) {
		this.handset = handset;
	}

	public String getRecaddr() {
		return this.recaddr;
	}

	public void setRecaddr(String recaddr) {
		this.recaddr = recaddr;
	}

	public String getEcid() {
		return this.ecid;
	}

	public void setEcid(String ecid) {
		this.ecid = ecid;
	}

	public String getSysname() {
		return this.sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getShopname() {
		return this.shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	public Timestamp getOperatedate() {
		return this.operatedate;
	}

	public void setOperatedate(Timestamp operatedate) {
		this.operatedate = operatedate;
	}

	public String getCusdesc() {
		return this.cusdesc;
	}

	public void setCusdesc(String cusdesc) {
		this.cusdesc = cusdesc;
	}

	public String getCusdetail() {
		return this.cusdetail;
	}

	public void setCusdetail(String cusdetail) {
		this.cusdetail = cusdetail;
	}

	public String getOperateopinion() {
		return this.operateopinion;
	}

	public void setOperateopinion(String operateopinion) {
		this.operateopinion = operateopinion;
	}

	public String getOperateman() {
		return this.operateman;
	}

	public void setOperateman(String operateman) {
		this.operateman = operateman;
	}

	public String getOperateremark() {
		return this.operateremark;
	}

	public void setOperateremark(String operateremark) {
		this.operateremark = operateremark;
	}

	public String getRelid() {
		return this.relid;
	}

	public void setRelid(String relid) {
		this.relid = relid;
	}

	public String getGoodsendtype() {
		return this.goodsendtype;
	}

	public void setGoodsendtype(String goodsendtype) {
		this.goodsendtype = goodsendtype;
	}

	public String getBackresult() {
		return this.backresult;
	}

	public void setBackresult(String backresult) {
		this.backresult = backresult;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}