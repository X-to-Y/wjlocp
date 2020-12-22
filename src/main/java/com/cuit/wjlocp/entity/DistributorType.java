package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (DistributorType)实体类
 *  经销商类别
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class DistributorType implements Serializable {
    private static final long serialVersionUID = -24125607104737848L;
    
    private Integer id;
    
    private String name;


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

}