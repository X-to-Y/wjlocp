package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (BasicInfo)实体类
 *  经销商会员信息的基本信息
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class BasicInfo implements Serializable {
    private static final long serialVersionUID = 760561682713309883L;
    
    private Integer id;
    
    private String distributorname;
    
    private String distributornum;
    
    private String distributorsubname;
    
    private String orgname;
    
    private Integer distributortype;
    
    private String memo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistributorname() {
        return distributorname;
    }

    public void setDistributorname(String distributorname) {
        this.distributorname = distributorname;
    }

    public String getDistributornum() {
        return distributornum;
    }

    public void setDistributornum(String distributornum) {
        this.distributornum = distributornum;
    }

    public String getDistributorsubname() {
        return distributorsubname;
    }

    public void setDistributorsubname(String distributorsubname) {
        this.distributorsubname = distributorsubname;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public Integer getDistributortype() {
        return distributortype;
    }

    public void setDistributortype(Integer distributortype) {
        this.distributortype = distributortype;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

}