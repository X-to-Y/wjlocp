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
    
    private Integer receiveorder;
    
    private String name;
    
    private String tel;
    
    private String receiveaddress;
    
    private String receiveunit;
    
    private String idcard;
    
    private String memo;
    
    private Integer isaddress;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReceiveorder() {
        return receiveorder;
    }

    public void setReceiveorder(Integer receiveorder) {
        this.receiveorder = receiveorder;
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

    public String getReceiveaddress() {
        return receiveaddress;
    }

    public void setReceiveaddress(String receiveaddress) {
        this.receiveaddress = receiveaddress;
    }

    public String getReceiveunit() {
        return receiveunit;
    }

    public void setReceiveunit(String receiveunit) {
        this.receiveunit = receiveunit;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getIsaddress() {
        return isaddress;
    }

    public void setIsaddress(Integer isaddress) {
        this.isaddress = isaddress;
    }

}