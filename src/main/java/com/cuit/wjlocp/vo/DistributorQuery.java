package com.cuit.wjlocp.vo;

import org.apache.poi.ss.formula.ptg.Ptg;

/**
 * Created by chocho on 2021/1/3.
 * 模糊查询经销商信息实体
 */
public class DistributorQuery {
    //用户名
    private String userName;
    //状态
    private String isFreeze;
    //角色
    private String actorType;
    //真实姓名
    private String name;
    //手机号码
    private String tel;
    //性别
    private String sex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(String isFreeze) {
        this.isFreeze = isFreeze;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
