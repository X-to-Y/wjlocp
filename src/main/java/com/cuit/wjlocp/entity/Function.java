package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (Function)实体类
 * 功能
 * 查看会员信息，账号信息等
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class Function implements Serializable {
    private static final long serialVersionUID = -77800259020365177L;
    
    private Integer id;
    
    private String name;
    
    private Integer order;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

}