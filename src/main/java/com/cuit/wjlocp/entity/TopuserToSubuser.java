package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.util.Date;
import java.io.Serializable;

/**
 * (TopuserToSubuser)实体类
 * 总经销商账号和子经销商账号关系
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class TopuserToSubuser implements Serializable {
    private static final long serialVersionUID = 145694040398373939L;
    
    private Integer id;
    
    private Integer topid;
    
    private Integer subid;
    
    private Date createtime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopid() {
        return topid;
    }

    public void setTopid(Integer topid) {
        this.topid = topid;
    }

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        this.subid = subid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

}