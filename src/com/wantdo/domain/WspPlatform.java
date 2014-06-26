package com.wantdo.domain;



/**
 * WspPlatform entity. @author MyEclipse Persistence Tools
 */

public class WspPlatform  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String systemname;
     private String systemurl;
     private String remark;
     private String isenable;


    // Constructors

    /** default constructor */
    public WspPlatform() {
    }

    
    /** full constructor */
    public WspPlatform(String systemname, String systemurl, String remark, String isenable) {
        this.systemname = systemname;
        this.systemurl = systemurl;
        this.remark = remark;
        this.isenable = isenable;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemname() {
        return this.systemname;
    }
    
    public void setSystemname(String systemname) {
        this.systemname = systemname;
    }

    public String getSystemurl() {
        return this.systemurl;
    }
    
    public void setSystemurl(String systemurl) {
        this.systemurl = systemurl;
    }

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsenable() {
        return this.isenable;
    }
    
    public void setIsenable(String isenable) {
        this.isenable = isenable;
    }
   








}