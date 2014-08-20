package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * CusOrdermst entity. @author MyEclipse Persistence Tools
 */

public class CusOrdermst implements java.io.Serializable {

	// Fields

	private Integer cusid;
	private String wspid;
	private String sendflg;
	private String ecid;
	private String sysname;
	private String shopname;
	private String shopmanager;
	private String orderpaysum;
	private Timestamp orderdate;
	private String linkman;
	private String handset;
	private String recaddr;
	private Timestamp operatedate;
	private String cusdesc;
	private String cusdetail;
	private String operateopinion;
	private String operateman;
	private String operateremark;
	private String incomingNo;
	private String relid;
	private String dealerflag;
	private String goodsendtype;
	private String onlineflag;
	private String refamount;
	private String freight;
	private String pricedisparity;
	private String shopemail;
	private String shopindustry;
	private String shopno;
	private String waybill;
	private String wspshopid;
	private String address;
	private String image;
	

	// Constructors

	/** default constructor */
	public CusOrdermst() {
	}

	/** full constructor */
	public CusOrdermst(String wspid, String sendflg, String ecid,
			String sysname, String shopname, String shopmanager,
			String orderpaysum, Timestamp orderdate, String linkman,
			String handset, String recaddr, Timestamp operatedate,
			String cusdesc, String cusdetail, String operateopinion,
			String operateman, String operateremark, String incomingNo,
			String relid, String dealerflag, String goodsendtype,
			String onlineflag, String refamount, String freight,
			String pricedisparity, String shopemail, String shopindustry,
			String shopno, String waybill, String wspshopid, String address,
			String image) {
		this.wspid = wspid;
		this.sendflg = sendflg;
		this.ecid = ecid;
		this.sysname = sysname;
		this.shopname = shopname;
		this.shopmanager = shopmanager;
		this.orderpaysum = orderpaysum;
		this.orderdate = orderdate;
		this.linkman = linkman;
		this.handset = handset;
		this.recaddr = recaddr;
		this.operatedate = operatedate;
		this.cusdesc = cusdesc;
		this.cusdetail = cusdetail;
		this.operateopinion = operateopinion;
		this.operateman = operateman;
		this.operateremark = operateremark;
		this.incomingNo = incomingNo;
		this.relid = relid;
		this.dealerflag = dealerflag;
		this.goodsendtype = goodsendtype;
		this.onlineflag = onlineflag;
		this.refamount = refamount;
		this.freight = freight;
		this.pricedisparity = pricedisparity;
		this.shopemail = shopemail;
		this.shopindustry = shopindustry;
		this.shopno = shopno;
		this.waybill = waybill;
		this.wspshopid = wspshopid;
		this.address = address;
		this.image = image;
	}

	// Property accessors

	public Integer getCusid() {
		return this.cusid;
	}

	public void setCusid(Integer cusid) {
		this.cusid = cusid;
	}

	public String getWspid() {
		return this.wspid;
	}

	public void setWspid(String wspid) {
		this.wspid = wspid;
	}

	public String getSendflg() {
		return this.sendflg;
	}

	public void setSendflg(String sendflg) {
		this.sendflg = sendflg;
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

	public String getShopmanager() {
		return this.shopmanager;
	}

	public void setShopmanager(String shopmanager) {
		this.shopmanager = shopmanager;
	}

	public String getOrderpaysum() {
		return this.orderpaysum;
	}

	public void setOrderpaysum(String orderpaysum) {
		this.orderpaysum = orderpaysum;
	}

	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
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

	public String getIncomingNo() {
		return this.incomingNo;
	}

	public void setIncomingNo(String incomingNo) {
		this.incomingNo = incomingNo;
	}

	public String getRelid() {
		return this.relid;
	}

	public void setRelid(String relid) {
		this.relid = relid;
	}

	public String getDealerflag() {
		return this.dealerflag;
	}

	public void setDealerflag(String dealerflag) {
		this.dealerflag = dealerflag;
	}

	public String getGoodsendtype() {
		return this.goodsendtype;
	}

	public void setGoodsendtype(String goodsendtype) {
		this.goodsendtype = goodsendtype;
	}

	public String getOnlineflag() {
		return this.onlineflag;
	}

	public void setOnlineflag(String onlineflag) {
		this.onlineflag = onlineflag;
	}

	public String getRefamount() {
		return this.refamount;
	}

	public void setRefamount(String refamount) {
		this.refamount = refamount;
	}

	public String getFreight() {
		return this.freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getPricedisparity() {
		return this.pricedisparity;
	}

	public void setPricedisparity(String pricedisparity) {
		this.pricedisparity = pricedisparity;
	}

	public String getShopemail() {
		return this.shopemail;
	}

	public void setShopemail(String shopemail) {
		this.shopemail = shopemail;
	}

	public String getShopindustry() {
		return shopindustry;
	}

	public void setShopindustry(String shopindustry) {
		this.shopindustry = shopindustry;
	}

	public String getShopno() {
		return shopno;
	}

	public void setShopno(String shopno) {
		this.shopno = shopno;
	}

	public String getWaybill() {
		return waybill;
	}

	public void setWaybill(String waybill) {
		this.waybill = waybill;
	}

	public String getWspshopid() {
		return wspshopid;
	}

	public void setWspshopid(String wspshopid) {
		this.wspshopid = wspshopid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}