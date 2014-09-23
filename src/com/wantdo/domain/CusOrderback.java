package com.wantdo.domain;

import java.util.Date;


/**
 * CusOrderback entity. @author MyEclipse Persistence Tools
 */

public class CusOrderback  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Date orderdate;
     private String purid;
     private String supplier;
     private String goodsname;
     private String barcode;
     private String goodsid;
     private String goodsproperty;
     private String num;
     private String price;
     private String fare;
     private String total;
     private String remark1;
     private String express;
     private String waybill;
     private String arrivalnum;
     private String mistake;
     private String condition;
     private Date arrivaltime;
     private String openman;
     private String signman;
     private String remark2;
     private String imgorder;
     private String intact;
     private String purresult;
     private String status;


    // Constructors

    /** default constructor */
    public CusOrderback() {
    }

    
    /** full constructor */
	public CusOrderback(Date orderdate, String purid, String supplier,
			String goodsname, String barcode, String goodsid,
			String goodsproperty, String num, String price, String fare,
			String total, String remark1, String express, String waybill,
			String arrivalnum, String mistake, String condition,
			Date arrivaltime, String openman, String signman, String remark2,
			String imgorder, String intact,String purresult,String status) {
        this.orderdate = orderdate;
        this.purid = purid;
        this.supplier = supplier;
        this.goodsname = goodsname;
        this.barcode = barcode;
        this.goodsid = goodsid;
        this.goodsproperty = goodsproperty;
        this.num = num;
        this.price = price;
        this.fare = fare;
        this.total = total;
        this.remark1 = remark1;
        this.express = express;
        this.waybill = waybill;
        this.arrivalnum = arrivalnum;
        this.mistake = mistake;
        this.condition = condition;
        this.arrivaltime = arrivaltime;
        this.openman = openman;
        this.signman = signman;
        this.remark2 = remark2;
        this.imgorder = imgorder;
        this.intact = intact;
        this.purresult = purresult;
        this.status = status;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderdate() {
        return this.orderdate;
    }
    
    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public String getPurid() {
        return this.purid;
    }
    
    public void setPurid(String purid) {
        this.purid = purid;
    }

    public String getSupplier() {
        return this.supplier;
    }
    
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getGoodsname() {
        return this.goodsname;
    }
    
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getGoodsid() {
        return this.goodsid;
    }
    
    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsproperty() {
        return this.goodsproperty;
    }
    
    public void setGoodsproperty(String goodsproperty) {
        this.goodsproperty = goodsproperty;
    }

    public String getNum() {
        return this.num;
    }
    
    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return this.price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }

    public String getFare() {
        return this.fare;
    }
    
    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getTotal() {
        return this.total;
    }
    
    public void setTotal(String total) {
        this.total = total;
    }

    public String getRemark1() {
        return this.remark1;
    }
    
    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getExpress() {
        return this.express;
    }
    
    public void setExpress(String express) {
        this.express = express;
    }

    public String getWaybill() {
        return this.waybill;
    }
    
    public void setWaybill(String waybill) {
        this.waybill = waybill;
    }

    public String getArrivalnum() {
        return this.arrivalnum;
    }
    
    public void setArrivalnum(String arrivalnum) {
        this.arrivalnum = arrivalnum;
    }

    public String getMistake() {
        return this.mistake;
    }
    
    public void setMistake(String mistake) {
        this.mistake = mistake;
    }

    public String getCondition() {
        return this.condition;
    }
    
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Date getArrivaltime() {
        return this.arrivaltime;
    }
    
    public void setArrivaltime(Date arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    public String getOpenman() {
        return this.openman;
    }
    
    public void setOpenman(String openman) {
        this.openman = openman;
    }

    public String getSignman() {
        return this.signman;
    }
    
    public void setSignman(String signman) {
        this.signman = signman;
    }

    public String getRemark2() {
        return this.remark2;
    }
    
    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }


	public String getImgorder() {
		return imgorder;
	}


	public void setImgorder(String imgorder) {
		this.imgorder = imgorder;
	}


	public String getIntact() {
		return intact;
	}


	public void setIntact(String intact) {
		this.intact = intact;
	}


	public String getPurresult() {
		return purresult;
	}


	public void setPurresult(String purresult) {
		this.purresult = purresult;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
   
}