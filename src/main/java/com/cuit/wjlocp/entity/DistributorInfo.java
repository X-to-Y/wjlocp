package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (DistributorInfo)实体类
 *
 * 经销商信息
 *
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class DistributorInfo implements Serializable {
    private static final long serialVersionUID = 153963487776002565L;
    
    private Integer id;
    
    private Integer memberid;
    
    private Integer accountid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberid() {
        return memberid;
    }

    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    public Integer getAccountid() {
        return accountid;
    }

    public void setAccountid(Integer accountid) {
        this.accountid = accountid;
    }

}