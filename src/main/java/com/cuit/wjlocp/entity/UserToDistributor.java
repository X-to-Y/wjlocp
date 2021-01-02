package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (UserToDistributor)实体类
 * 经销商账号与之关联的经销商信息
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class UserToDistributor implements Serializable {
    private static final long serialVersionUID = 778902290832170755L;
    
    private Integer id;
    
    private Integer userId;
    
    private Integer distributorId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    @Override
    public String toString() {
        return "UserToDistributor{" +
                "id=" + id +
                ", userId=" + userId +
                ", distributorId=" + distributorId +
                '}';
    }
}