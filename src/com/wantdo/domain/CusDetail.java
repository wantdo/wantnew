package com.wantdo.domain;



/**
 * CusDetail entity. @author MyEclipse Persistence Tools
 */

public class CusDetail  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private CusDesc cusDesc;
     private String detail;


    // Constructors

    /** default constructor */
    public CusDetail() {
    }

    
    /** full constructor */
    public CusDetail(CusDesc cusDesc, String detail) {
        this.cusDesc = cusDesc;
        this.detail = detail;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public CusDesc getCusDesc() {
        return this.cusDesc;
    }
    
    public void setCusDesc(CusDesc cusDesc) {
        this.cusDesc = cusDesc;
    }

    public String getDetail() {
        return this.detail;
    }
    
    public void setDetail(String detail) {
        this.detail = detail;
    }
   








}