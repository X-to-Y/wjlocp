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
    
    private String clientnum;
    
    private String clientname;
    
    private Object creditlimit;
    
    private Object deliveryblance;
    
    private Object discountblance;
    
    private Object bond;
    
    private String memo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientnum() {
        return clientnum;
    }

    public void setClientnum(String clientnum) {
        this.clientnum = clientnum;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Object getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(Object creditlimit) {
        this.creditlimit = creditlimit;
    }

    public Object getDeliveryblance() {
        return deliveryblance;
    }

    public void setDeliveryblance(Object deliveryblance) {
        this.deliveryblance = deliveryblance;
    }

    public Object getDiscountblance() {
        return discountblance;
    }

    public void setDiscountblance(Object discountblance) {
        this.discountblance = discountblance;
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

}