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
    
    private Integer basicid;
    
    private Integer receiveid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicid() {
        return basicid;
    }

    public void setBasicid(Integer basicid) {
        this.basicid = basicid;
    }

    public Integer getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(Integer receiveid) {
        this.receiveid = receiveid;
    }

}