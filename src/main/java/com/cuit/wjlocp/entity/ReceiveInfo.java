package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (ReceiveInfo)实体类
 *  经销商会员信息的收货信息
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class ReceiveInfo implements Serializable {
    private static final long serialVersionUID = -21136651795163523L;
    
    private Integer id;
    
    private Integer receiveOrder;
    
    private String name;
    
    private String tel;
    
    private String receiveAddress;
    
    private String receiveUnit;
    
    private String idCard;
    
    private String memo;
    
    private Integer isAddress;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiveOrder() {
        return receiveOrder;
    }

    public void setReceiveOrder(Integer receiveOrder) {
        this.receiveOrder = receiveOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    public String getReceiveUnit() {
        return receiveUnit;
    }

    public void setReceiveUnit(String receiveUnit) {
        this.receiveUnit = receiveUnit;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getIsAddress() {
        return isAddress;
    }

    public void setIsAddress(Integer isAddress) {
        this.isAddress = isAddress;
    }

    @Override
    public String toString() {
        return "ReceiveInfo{" +
                "id=" + id +
                ", receiveOrder=" + receiveOrder +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", receiveUnit='" + receiveUnit + '\'' +
                ", idCard='" + idCard + '\'' +
                ", memo='" + memo + '\'' +
                ", isAddress=" + isAddress +
                '}';
    }
}