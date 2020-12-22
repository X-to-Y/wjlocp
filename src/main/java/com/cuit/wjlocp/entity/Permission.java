package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (Permission)实体类
 *  接口表
 *  角色所获得的功能菜单
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class Permission implements Serializable {
    private static final long serialVersionUID = 427072038336148383L;
    
    private Integer id;
    
    private Integer actorid;
    
    private String permission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActorid() {
        return actorid;
    }

    public void setActorid(Integer actorid) {
        this.actorid = actorid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}