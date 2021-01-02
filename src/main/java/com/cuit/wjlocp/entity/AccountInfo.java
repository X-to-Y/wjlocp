package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (AccountInfo)实体类
 * 经销商账号信息
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class AccountInfo implements Serializable {
    private static final long serialVersionUID = -71948799289641131L;
    
    private Integer id;
    
    private String clientNum;
    
    private String clientName;
    
    private Object creditLimit;
    
    private Object deliveryBlance;
    
    private Object discountBlance;
    
    private Object bond;
    
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

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Object getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Object creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Object getDeliveryBlance() {
        return deliveryBlance;
    }

    public void setDeliveryBlance(Object deliveryBlance) {
        this.deliveryBlance = deliveryBlance;
    }

    public Object getDiscountBlance() {
        return discountBlance;
    }

    public void setDiscountBlance(Object discountBlance) {
        this.discountBlance = discountBlance;
    }

    public Object getBond() {
        return bond;
    }

    public void setBond(Object bond) {
        this.bond = bond;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "id=" + id +
                ", clientNum='" + clientNum + '\'' +
                ", clientName='" + clientName + '\'' +
                ", creditLimit=" + creditLimit +
                ", deliveryBlance=" + deliveryBlance +
                ", discountBlance=" + discountBlance +
                ", bond=" + bond +
                ", memo='" + memo + '\'' +
                '}';
    }
}