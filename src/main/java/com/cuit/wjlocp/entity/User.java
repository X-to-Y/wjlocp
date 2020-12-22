package com.cuit.wjlocp.entity;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * (User)实体类
 * 用户表
 * （包括经销商账号和运营账号）
 * @author X-to-Y
 * @since 2020-12-19 13:11:08
 */

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 902879764699954841L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String name;
    
    private String memo;
    
    private Integer actortype;
    
    private Integer isfreeze;
    
    private String mail;
    
    private String tel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getActortype() {
        return actortype;
    }

    public void setActortype(Integer actortype) {
        this.actortype = actortype;
    }

    public Integer getIsfreeze() {
        return isfreeze;
    }

    public void setIsfreeze(Integer isfreeze) {
        this.isfreeze = isfreeze;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

}