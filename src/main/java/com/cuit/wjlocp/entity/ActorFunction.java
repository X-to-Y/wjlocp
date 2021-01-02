package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (ActorFunction)实体类
 *  角色功能
 *  关联角色和具体功能
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */

@Entity
public class ActorFunction implements Serializable {
    private static final long serialVersionUID = 506202222515848817L;
    
    private Integer id;
    
    private Integer functionId;
    
    private Integer actorId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    @Override
    public String toString() {
        return "ActorFunction{" +
                "id=" + id +
                ", functionId=" + functionId +
                ", actorId=" + actorId +
                '}';
    }
}