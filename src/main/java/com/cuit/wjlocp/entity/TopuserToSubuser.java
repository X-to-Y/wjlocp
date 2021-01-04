package com.cuit.wjlocp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

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
    
    private Integer topId;
    
    private Integer subId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TopuserToSubuser{" +
                "id=" + id +
                ", topId=" + topId +
                ", subId=" + subId +
                ", createTime=" + createTime +
                '}';
    }
}