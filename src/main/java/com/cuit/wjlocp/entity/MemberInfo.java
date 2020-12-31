package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (MemberInfo)实体类
 * 经销商会员信息
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */
@Entity
public class MemberInfo implements Serializable {
    private static final long serialVersionUID = -77077625120398126L;
    
    private Integer id;
    
    private Integer basicId;
    
    private Integer receiveId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id=" + id +
                ", basicId=" + basicId +
                ", receiveId=" + receiveId +
                '}';
    }
}