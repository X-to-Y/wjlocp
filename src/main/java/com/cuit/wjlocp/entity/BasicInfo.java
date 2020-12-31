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
    
    private String distributorName;
    
    private String distributorNum;
    
    private String distributorSubName;
    
    private String orgName;
    
    private Integer distributorType;
    
    private String memo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getDistributorNum() {
        return distributorNum;
    }

    public void setDistributorNum(String distributorNum) {
        this.distributorNum = distributorNum;
    }

    public String getDistributorSubName() {
        return distributorSubName;
    }

    public void setDistributorSubName(String distributorSubName) {
        this.distributorSubName = distributorSubName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getDistributorType() {
        return distributorType;
    }

    public void setDistributorType(Integer distributorType) {
        this.distributorType = distributorType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "BasicInfo{" +
                "id=" + id +
                ", distributorName='" + distributorName + '\'' +
                ", distributorNum='" + distributorNum + '\'' +
                ", distributorSubName='" + distributorSubName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", distributorType=" + distributorType +
                ", memo='" + memo + '\'' +
                '}';
    }
}