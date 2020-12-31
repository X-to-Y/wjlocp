package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (Actor)实体类
 *  a_actor
 *  运营人员，经销商账号等
 * @author X-to-Y
 * @since 2020-12-19 13:11:03
 */

@Entity
public class Actor implements Serializable {
    private static final long serialVersionUID = -77800101097437332L;
    
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