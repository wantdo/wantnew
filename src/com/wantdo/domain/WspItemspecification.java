package com.wantdo.domain;

/**
 * WspItemspecification entity. @author MyEclipse Persistence Tools
 */

public class WspItemspecification implements java.io.Serializable {

	// Fields

	private String skuid;
	private String itemno;
	private String skuname;
	private String attrvalid;
	private String barcode;
	private String goodno;
	private Double saleprice;
	private Double specialprice;
	private Double weight;
	private Double length;
	private Double width;
	private Double height;
	private String isunsaled;
	private String strvalues;
	private String strdisplay;
	private String picnames;
	private Double salescount;
	private String i6itemno;
	private Double dailyprice;
	private String imageurl;

	// Constructors

	/** default constructor */
	public WspItemspecification() {
	}

	/** minimal constructor */
	public WspItemspecification(String itemno) {
		this.itemno = itemno;
	}

	/** full constructor */
	public WspItemspecification(String itemno, String skuname,
			String attrvalid, String barcode, String goodno, Double saleprice,
			Double specialprice, Double weight, Double length, Double width,
			Double height, String isunsaled, String strvalues,
			String strdisplay, String picnames, Double salescount,
			String i6itemno, Double dailyprice, String imageurl) {
		this.itemno = itemno;
		this.skuname = skuname;
		this.attrvalid = attrvalid;
		this.barcode = barcode;
		this.goodno = goodno;
		this.saleprice = saleprice;
		this.specialprice = specialprice;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
		this.isunsaled = isunsaled;
		this.strvalues = strvalues;
		this.strdisplay = strdisplay;
		this.picnames = picnames;
		this.salescount = salescount;
		this.i6itemno = i6itemno;
		this.dailyprice = dailyprice;
		this.imageurl = imageurl;
	}

	// Property accessors

	public String getSkuid() {
		return this.skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public String getItemno() {
		return this.itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getSkuname() {
		return this.skuname;
	}

	public void setSkuname(String skuname) {
		this.skuname = skuname;
	}

	public String getAttrvalid() {
		return this.attrvalid;
	}

	public void setAttrvalid(String attrvalid) {
		this.attrvalid = attrvalid;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getGoodno() {
		return this.goodno;
	}

	public void setGoodno(String goodno) {
		this.goodno = goodno;
	}

	public Double getSaleprice() {
		return this.saleprice;
	}

	public void setSaleprice(Double saleprice) {
		this.saleprice = saleprice;
	}

	public Double getSpecialprice() {
		return this.specialprice;
	}

	public void setSpecialprice(Double specialprice) {
		this.specialprice = specialprice;
	}

	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return this.length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return this.width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getIsunsaled() {
		return this.isunsaled;
	}

	public void setIsunsaled(String isunsaled) {
		this.isunsaled = isunsaled;
	}

	public String getStrvalues() {
		return this.strvalues;
	}

	public void setStrvalues(String strvalues) {
		this.strvalues = strvalues;
	}

	public String getStrdisplay() {
		return this.strdisplay;
	}

	public void setStrdisplay(String strdisplay) {
		this.strdisplay = strdisplay;
	}

	public String getPicnames() {
		return this.picnames;
	}

	public void setPicnames(String picnames) {
		this.picnames = picnames;
	}

	public Double getSalescount() {
		return this.salescount;
	}

	public void setSalescount(Double salescount) {
		this.salescount = salescount;
	}

	public String getI6itemno() {
		return this.i6itemno;
	}

	public void setI6itemno(String i6itemno) {
		this.i6itemno = i6itemno;
	}

	public Double getDailyprice() {
		return this.dailyprice;
	}

	public void setDailyprice(Double dailyprice) {
		this.dailyprice = dailyprice;
	}

	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

}