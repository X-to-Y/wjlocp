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
    
    private String userName;
    
    private String passWord;
    
    private String name;
    
    private String memo;
    
    private Integer actorType;
    
    private Integer isFreeze;
    
    private String mail;
    
    private String tel;

    private Integer orgType;

    private Integer sex;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
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

    public Integer getActorType() {
        return actorType;
    }

    public void setActorType(Integer actorType) {
        this.actorType = actorType;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
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

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", name='" + name + '\'' +
                ", memo='" + memo + '\'' +
                ", actorType=" + actorType +
                ", isFreeze=" + isFreeze +
                ", mail='" + mail + '\'' +
                ", tel='" + tel + '\'' +
                ", orgType=" + orgType +
                ", sex=" + sex +
                '}';
    }
}
