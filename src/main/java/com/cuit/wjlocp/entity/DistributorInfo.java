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
    
    private Integer memberId;
    
    private Integer accountId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "DistributorInfo{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", accountId=" + accountId +
                '}';
    }
}