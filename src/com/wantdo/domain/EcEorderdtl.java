package com.wantdo.domain;

import java.sql.Timestamp;

/**
 * EcEorderdtl entity. @author MyEclipse Persistence Tools
 */

public class EcEorderdtl implements java.io.Serializable {

	// Fields

	private EcEorderdtlId id;
	private String orderno;
	private Integer childflg;
	private Integer parentid;
	private String itemno;
	private String ranks;
	private String msunit;
	private Double qty;
	private Double sqty;
	private String pricode;
	private Double pricexs;
	private Double price;
	private Double ordhwsum;
	private Double ordersum;
	private Double discrate;
	private Double discsum;
	private Double sendsum;
	private Double sendxs;
	private Double sendzk;
	private Double invsum;
	private Double actsendqty;
	private Double sendqty;
	private Double invqty;
	private Double ssendqty;
	private Double sinvqty;
	private Double sactsendqty;
	private String curtype;
	private Double exchgrate;
	private Double fprice;
	private Double fordhwsum;
	private Double fordersum;
	private Double fdiscsum;
	private Double fsendsum;
	private Double fsendxs;
	private Double fsendzk;
	private Double finvsum;
	private String fmsunit;
	private Double unitchgn;
	private Integer chgbase;
	private Double fqty;
	private Double fsendqty;
	private Double finvqty;
	private Double factsendqty;
	private Timestamp reqdate;
	private Timestamp deliverdate;
	private Timestamp recdate;
	private String remarks;
	private Short outpriflg;
	private Short vipflg;
	private Short sendflg;
	private Short minvflg;
	private Short recflg;
	private Double maxprice;
	private Double minprice;
	private Double fmaxprice;
	private Double fminprice;
	private String batchno;
	private Short relline;
	private Double versionno;
	private Double versionmoney;
	private Double typeno;
	private Double typemoney;
	private Double taxrate;
	private Double fnotaxprice;
	private Double notaxprice;
	private String ispattern;
	private Double ffeesum;
	private Double feesum;
	private String attrvalid;
	private Double umConvA;
	private Double umConvAm;
	private Integer conBilnid;
	private String conCode;
	private String skuid;
	private Integer cqty;
	private Double orderjf;
	private String isintergal;
	private Double returnjf;
	private Integer id_1;
	private Double discount;
	private String ispresent;
	private Integer inventorytype;
	private String relid;
	private String shipno;
	private String defwhloc;
	private String sourceorder;
	private Integer sourcelineid;
	private String barcode;
	private String scanpdaflg;
	private String snapshoturl;
	private String defwhouse;
	private String returnflag;
	private String stocklockflag;
	private String defshelf;
	private String supplierno;
	private String purchaseflag;
	private String purchaseorderid;

	// Constructors

	/** default constructor */
	public EcEorderdtl() {
	}

	/** minimal constructor */
	public EcEorderdtl(EcEorderdtlId id) {
		this.id = id;
	}

	/** full constructor */
	public EcEorderdtl(EcEorderdtlId id, String orderno, Integer childflg,
			Integer parentid, String itemno, String ranks, String msunit,
			Double qty, Double sqty, String pricode, Double pricexs,
			Double price, Double ordhwsum, Double ordersum, Double discrate,
			Double discsum, Double sendsum, Double sendxs, Double sendzk,
			Double invsum, Double actsendqty, Double sendqty, Double invqty,
			Double ssendqty, Double sinvqty, Double sactsendqty,
			String curtype, Double exchgrate, Double fprice, Double fordhwsum,
			Double fordersum, Double fdiscsum, Double fsendsum, Double fsendxs,
			Double fsendzk, Double finvsum, String fmsunit, Double unitchgn,
			Integer chgbase, Double fqty, Double fsendqty, Double finvqty,
			Double factsendqty, Timestamp reqdate, Timestamp deliverdate,
			Timestamp recdate, String remarks, Short outpriflg, Short vipflg,
			Short sendflg, Short minvflg, Short recflg, Double maxprice,
			Double minprice, Double fmaxprice, Double fminprice,
			String batchno, Short relline, Double versionno,
			Double versionmoney, Double typeno, Double typemoney,
			Double taxrate, Double fnotaxprice, Double notaxprice,
			String ispattern, Double ffeesum, Double feesum, String attrvalid,
			Double umConvA, Double umConvAm, Integer conBilnid, String conCode,
			String skuid, Integer cqty, Double orderjf, String isintergal,
			Double returnjf, Integer id_1, Double discount, String ispresent,
			Integer inventorytype, String relid, String shipno,
			String defwhloc, String sourceorder, Integer sourcelineid,
			String barcode, String scanpdaflg, String snapshoturl,
			String defwhouse, String returnflag, String stocklockflag,
			String defshelf, String supplierno, String purchaseflag,
			String purchaseorderid) {
		this.id = id;
		this.orderno = orderno;
		this.childflg = childflg;
		this.parentid = parentid;
		this.itemno = itemno;
		this.ranks = ranks;
		this.msunit = msunit;
		this.qty = qty;
		this.sqty = sqty;
		this.pricode = pricode;
		this.pricexs = pricexs;
		this.price = price;
		this.ordhwsum = ordhwsum;
		this.ordersum = ordersum;
		this.discrate = discrate;
		this.discsum = discsum;
		this.sendsum = sendsum;
		this.sendxs = sendxs;
		this.sendzk = sendzk;
		this.invsum = invsum;
		this.actsendqty = actsendqty;
		this.sendqty = sendqty;
		this.invqty = invqty;
		this.ssendqty = ssendqty;
		this.sinvqty = sinvqty;
		this.sactsendqty = sactsendqty;
		this.curtype = curtype;
		this.exchgrate = exchgrate;
		this.fprice = fprice;
		this.fordhwsum = fordhwsum;
		this.fordersum = fordersum;
		this.fdiscsum = fdiscsum;
		this.fsendsum = fsendsum;
		this.fsendxs = fsendxs;
		this.fsendzk = fsendzk;
		this.finvsum = finvsum;
		this.fmsunit = fmsunit;
		this.unitchgn = unitchgn;
		this.chgbase = chgbase;
		this.fqty = fqty;
		this.fsendqty = fsendqty;
		this.finvqty = finvqty;
		this.factsendqty = factsendqty;
		this.reqdate = reqdate;
		this.deliverdate = deliverdate;
		this.recdate = recdate;
		this.remarks = remarks;
		this.outpriflg = outpriflg;
		this.vipflg = vipflg;
		this.sendflg = sendflg;
		this.minvflg = minvflg;
		this.recflg = recflg;
		this.maxprice = maxprice;
		this.minprice = minprice;
		this.fmaxprice = fmaxprice;
		this.fminprice = fminprice;
		this.batchno = batchno;
		this.relline = relline;
		this.versionno = versionno;
		this.versionmoney = versionmoney;
		this.typeno = typeno;
		this.typemoney = typemoney;
		this.taxrate = taxrate;
		this.fnotaxprice = fnotaxprice;
		this.notaxprice = notaxprice;
		this.ispattern = ispattern;
		this.ffeesum = ffeesum;
		this.feesum = feesum;
		this.attrvalid = attrvalid;
		this.umConvA = umConvA;
		this.umConvAm = umConvAm;
		this.conBilnid = conBilnid;
		this.conCode = conCode;
		this.skuid = skuid;
		this.cqty = cqty;
		this.orderjf = orderjf;
		this.isintergal = isintergal;
		this.returnjf = returnjf;
		this.id_1 = id_1;
		this.discount = discount;
		this.ispresent = ispresent;
		this.inventorytype = inventorytype;
		this.relid = relid;
		this.shipno = shipno;
		this.defwhloc = defwhloc;
		this.sourceorder = sourceorder;
		this.sourcelineid = sourcelineid;
		this.barcode = barcode;
		this.scanpdaflg = scanpdaflg;
		this.snapshoturl = snapshoturl;
		this.defwhouse = defwhouse;
		this.returnflag = returnflag;
		this.stocklockflag = stocklockflag;
		this.defshelf = defshelf;
		this.supplierno = supplierno;
		this.purchaseflag = purchaseflag;
		this.purchaseorderid = purchaseorderid;
	}

	// Property accessors

	public EcEorderdtlId getId() {
		return this.id;
	}

	public void setId(EcEorderdtlId id) {
		this.id = id;
	}

	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public Integer getChildflg() {
		return this.childflg;
	}

	public void setChildflg(Integer childflg) {
		this.childflg = childflg;
	}

	public Integer getParentid() {
		return this.parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getItemno() {
		return this.itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public String getRanks() {
		return this.ranks;
	}

	public void setRanks(String ranks) {
		this.ranks = ranks;
	}

	public String getMsunit() {
		return this.msunit;
	}

	public void setMsunit(String msunit) {
		this.msunit = msunit;
	}

	public Double getQty() {
		return this.qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getSqty() {
		return this.sqty;
	}

	public void setSqty(Double sqty) {
		this.sqty = sqty;
	}

	public String getPricode() {
		return this.pricode;
	}

	public void setPricode(String pricode) {
		this.pricode = pricode;
	}

	public Double getPricexs() {
		return this.pricexs;
	}

	public void setPricexs(Double pricexs) {
		this.pricexs = pricexs;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getOrdhwsum() {
		return this.ordhwsum;
	}

	public void setOrdhwsum(Double ordhwsum) {
		this.ordhwsum = ordhwsum;
	}

	public Double getOrdersum() {
		return this.ordersum;
	}

	public void setOrdersum(Double ordersum) {
		this.ordersum = ordersum;
	}

	public Double getDiscrate() {
		return this.discrate;
	}

	public void setDiscrate(Double discrate) {
		this.discrate = discrate;
	}

	public Double getDiscsum() {
		return this.discsum;
	}

	public void setDiscsum(Double discsum) {
		this.discsum = discsum;
	}

	public Double getSendsum() {
		return this.sendsum;
	}

	public void setSendsum(Double sendsum) {
		this.sendsum = sendsum;
	}

	public Double getSendxs() {
		return this.sendxs;
	}

	public void setSendxs(Double sendxs) {
		this.sendxs = sendxs;
	}

	public Double getSendzk() {
		return this.sendzk;
	}

	public void setSendzk(Double sendzk) {
		this.sendzk = sendzk;
	}

	public Double getInvsum() {
		return this.invsum;
	}

	public void setInvsum(Double invsum) {
		this.invsum = invsum;
	}

	public Double getActsendqty() {
		return this.actsendqty;
	}

	public void setActsendqty(Double actsendqty) {
		this.actsendqty = actsendqty;
	}

	public Double getSendqty() {
		return this.sendqty;
	}

	public void setSendqty(Double sendqty) {
		this.sendqty = sendqty;
	}

	public Double getInvqty() {
		return this.invqty;
	}

	public void setInvqty(Double invqty) {
		this.invqty = invqty;
	}

	public Double getSsendqty() {
		return this.ssendqty;
	}

	public void setSsendqty(Double ssendqty) {
		this.ssendqty = ssendqty;
	}

	public Double getSinvqty() {
		return this.sinvqty;
	}

	public void setSinvqty(Double sinvqty) {
		this.sinvqty = sinvqty;
	}

	public Double getSactsendqty() {
		return this.sactsendqty;
	}

	public void setSactsendqty(Double sactsendqty) {
		this.sactsendqty = sactsendqty;
	}

	public String getCurtype() {
		return this.curtype;
	}

	public void setCurtype(String curtype) {
		this.curtype = curtype;
	}

	public Double getExchgrate() {
		return this.exchgrate;
	}

	public void setExchgrate(Double exchgrate) {
		this.exchgrate = exchgrate;
	}

	public Double getFprice() {
		return this.fprice;
	}

	public void setFprice(Double fprice) {
		this.fprice = fprice;
	}

	public Double getFordhwsum() {
		return this.fordhwsum;
	}

	public void setFordhwsum(Double fordhwsum) {
		this.fordhwsum = fordhwsum;
	}

	public Double getFordersum() {
		return this.fordersum;
	}

	public void setFordersum(Double fordersum) {
		this.fordersum = fordersum;
	}

	public Double getFdiscsum() {
		return this.fdiscsum;
	}

	public void setFdiscsum(Double fdiscsum) {
		this.fdiscsum = fdiscsum;
	}

	public Double getFsendsum() {
		return this.fsendsum;
	}

	public void setFsendsum(Double fsendsum) {
		this.fsendsum = fsendsum;
	}

	public Double getFsendxs() {
		return this.fsendxs;
	}

	public void setFsendxs(Double fsendxs) {
		this.fsendxs = fsendxs;
	}

	public Double getFsendzk() {
		return this.fsendzk;
	}

	public void setFsendzk(Double fsendzk) {
		this.fsendzk = fsendzk;
	}

	public Double getFinvsum() {
		return this.finvsum;
	}

	public void setFinvsum(Double finvsum) {
		this.finvsum = finvsum;
	}

	public String getFmsunit() {
		return this.fmsunit;
	}

	public void setFmsunit(String fmsunit) {
		this.fmsunit = fmsunit;
	}

	public Double getUnitchgn() {
		return this.unitchgn;
	}

	public void setUnitchgn(Double unitchgn) {
		this.unitchgn = unitchgn;
	}

	public Integer getChgbase() {
		return this.chgbase;
	}

	public void setChgbase(Integer chgbase) {
		this.chgbase = chgbase;
	}

	public Double getFqty() {
		return this.fqty;
	}

	public void setFqty(Double fqty) {
		this.fqty = fqty;
	}

	public Double getFsendqty() {
		return this.fsendqty;
	}

	public void setFsendqty(Double fsendqty) {
		this.fsendqty = fsendqty;
	}

	public Double getFinvqty() {
		return this.finvqty;
	}

	public void setFinvqty(Double finvqty) {
		this.finvqty = finvqty;
	}

	public Double getFactsendqty() {
		return this.factsendqty;
	}

	public void setFactsendqty(Double factsendqty) {
		this.factsendqty = factsendqty;
	}

	public Timestamp getReqdate() {
		return this.reqdate;
	}

	public void setReqdate(Timestamp reqdate) {
		this.reqdate = reqdate;
	}

	public Timestamp getDeliverdate() {
		return this.deliverdate;
	}

	public void setDeliverdate(Timestamp deliverdate) {
		this.deliverdate = deliverdate;
	}

	public Timestamp getRecdate() {
		return this.recdate;
	}

	public void setRecdate(Timestamp recdate) {
		this.recdate = recdate;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Short getOutpriflg() {
		return this.outpriflg;
	}

	public void setOutpriflg(Short outpriflg) {
		this.outpriflg = outpriflg;
	}

	public Short getVipflg() {
		return this.vipflg;
	}

	public void setVipflg(Short vipflg) {
		this.vipflg = vipflg;
	}

	public Short getSendflg() {
		return this.sendflg;
	}

	public void setSendflg(Short sendflg) {
		this.sendflg = sendflg;
	}

	public Short getMinvflg() {
		return this.minvflg;
	}

	public void setMinvflg(Short minvflg) {
		this.minvflg = minvflg;
	}

	public Short getRecflg() {
		return this.recflg;
	}

	public void setRecflg(Short recflg) {
		this.recflg = recflg;
	}

	public Double getMaxprice() {
		return this.maxprice;
	}

	public void setMaxprice(Double maxprice) {
		this.maxprice = maxprice;
	}

	public Double getMinprice() {
		return this.minprice;
	}

	public void setMinprice(Double minprice) {
		this.minprice = minprice;
	}

	public Double getFmaxprice() {
		return this.fmaxprice;
	}

	public void setFmaxprice(Double fmaxprice) {
		this.fmaxprice = fmaxprice;
	}

	public Double getFminprice() {
		return this.fminprice;
	}

	public void setFminprice(Double fminprice) {
		this.fminprice = fminprice;
	}

	public String getBatchno() {
		return this.batchno;
	}

	public void setBatchno(String batchno) {
		this.batchno = batchno;
	}

	public Short getRelline() {
		return this.relline;
	}

	public void setRelline(Short relline) {
		this.relline = relline;
	}

	public Double getVersionno() {
		return this.versionno;
	}

	public void setVersionno(Double versionno) {
		this.versionno = versionno;
	}

	public Double getVersionmoney() {
		return this.versionmoney;
	}

	public void setVersionmoney(Double versionmoney) {
		this.versionmoney = versionmoney;
	}

	public Double getTypeno() {
		return this.typeno;
	}

	public void setTypeno(Double typeno) {
		this.typeno = typeno;
	}

	public Double getTypemoney() {
		return this.typemoney;
	}

	public void setTypemoney(Double typemoney) {
		this.typemoney = typemoney;
	}

	public Double getTaxrate() {
		return this.taxrate;
	}

	public void setTaxrate(Double taxrate) {
		this.taxrate = taxrate;
	}

	public Double getFnotaxprice() {
		return this.fnotaxprice;
	}

	public void setFnotaxprice(Double fnotaxprice) {
		this.fnotaxprice = fnotaxprice;
	}

	public Double getNotaxprice() {
		return this.notaxprice;
	}

	public void setNotaxprice(Double notaxprice) {
		this.notaxprice = notaxprice;
	}

	public String getIspattern() {
		return this.ispattern;
	}

	public void setIspattern(String ispattern) {
		this.ispattern = ispattern;
	}

	public Double getFfeesum() {
		return this.ffeesum;
	}

	public void setFfeesum(Double ffeesum) {
		this.ffeesum = ffeesum;
	}

	public Double getFeesum() {
		return this.feesum;
	}

	public void setFeesum(Double feesum) {
		this.feesum = feesum;
	}

	public String getAttrvalid() {
		return this.attrvalid;
	}

	public void setAttrvalid(String attrvalid) {
		this.attrvalid = attrvalid;
	}

	public Double getUmConvA() {
		return this.umConvA;
	}

	public void setUmConvA(Double umConvA) {
		this.umConvA = umConvA;
	}

	public Double getUmConvAm() {
		return this.umConvAm;
	}

	public void setUmConvAm(Double umConvAm) {
		this.umConvAm = umConvAm;
	}

	public Integer getConBilnid() {
		return this.conBilnid;
	}

	public void setConBilnid(Integer conBilnid) {
		this.conBilnid = conBilnid;
	}

	public String getConCode() {
		return this.conCode;
	}

	public void setConCode(String conCode) {
		this.conCode = conCode;
	}

	public String getSkuid() {
		return this.skuid;
	}

	public void setSkuid(String skuid) {
		this.skuid = skuid;
	}

	public Integer getCqty() {
		return this.cqty;
	}

	public void setCqty(Integer cqty) {
		this.cqty = cqty;
	}

	public Double getOrderjf() {
		return this.orderjf;
	}

	public void setOrderjf(Double orderjf) {
		this.orderjf = orderjf;
	}

	public String getIsintergal() {
		return this.isintergal;
	}

	public void setIsintergal(String isintergal) {
		this.isintergal = isintergal;
	}

	public Double getReturnjf() {
		return this.returnjf;
	}

	public void setReturnjf(Double returnjf) {
		this.returnjf = returnjf;
	}

	public Integer getId_1() {
		return this.id_1;
	}

	public void setId_1(Integer id_1) {
		this.id_1 = id_1;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getIspresent() {
		return this.ispresent;
	}

	public void setIspresent(String ispresent) {
		this.ispresent = ispresent;
	}

	public Integer getInventorytype() {
		return this.inventorytype;
	}

	public void setInventorytype(Integer inventorytype) {
		this.inventorytype = inventorytype;
	}

	public String getRelid() {
		return this.relid;
	}

	public void setRelid(String relid) {
		this.relid = relid;
	}

	public String getShipno() {
		return this.shipno;
	}

	public void setShipno(String shipno) {
		this.shipno = shipno;
	}

	public String getDefwhloc() {
		return this.defwhloc;
	}

	public void setDefwhloc(String defwhloc) {
		this.defwhloc = defwhloc;
	}

	public String getSourceorder() {
		return this.sourceorder;
	}

	public void setSourceorder(String sourceorder) {
		this.sourceorder = sourceorder;
	}

	public Integer getSourcelineid() {
		return this.sourcelineid;
	}

	public void setSourcelineid(Integer sourcelineid) {
		this.sourcelineid = sourcelineid;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getScanpdaflg() {
		return this.scanpdaflg;
	}

	public void setScanpdaflg(String scanpdaflg) {
		this.scanpdaflg = scanpdaflg;
	}

	public String getSnapshoturl() {
		return this.snapshoturl;
	}

	public void setSnapshoturl(String snapshoturl) {
		this.snapshoturl = snapshoturl;
	}

	public String getDefwhouse() {
		return this.defwhouse;
	}

	public void setDefwhouse(String defwhouse) {
		this.defwhouse = defwhouse;
	}

	public String getReturnflag() {
		return this.returnflag;
	}

	public void setReturnflag(String returnflag) {
		this.returnflag = returnflag;
	}

	public String getStocklockflag() {
		return this.stocklockflag;
	}

	public void setStocklockflag(String stocklockflag) {
		this.stocklockflag = stocklockflag;
	}

	public String getDefshelf() {
		return this.defshelf;
	}

	public void setDefshelf(String defshelf) {
		this.defshelf = defshelf;
	}

	public String getSupplierno() {
		return this.supplierno;
	}

	public void setSupplierno(String supplierno) {
		this.supplierno = supplierno;
	}

	public String getPurchaseflag() {
		return this.purchaseflag;
	}

	public void setPurchaseflag(String purchaseflag) {
		this.purchaseflag = purchaseflag;
	}

	public String getPurchaseorderid() {
		return this.purchaseorderid;
	}

	public void setPurchaseorderid(String purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
	}

}