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
    
    private String actorName;

    private String memo;

    private Integer isFreeze;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", actorName='" + actorName + '\'' +
                ", memo='" + memo + '\'' +
                ", isFreeze=" + isFreeze +
                '}';
    }
}