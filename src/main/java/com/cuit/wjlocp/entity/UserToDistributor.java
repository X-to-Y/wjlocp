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
    
    private Integer userid;
    
    private Integer distributorid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDistributorid() {
        return distributorid;
    }

    public void setDistributorid(Integer distributorid) {
        this.distributorid = distributorid;
    }

}