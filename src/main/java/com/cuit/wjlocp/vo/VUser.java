package com.cuit.wjlocp.vo;

import com.cuit.wjlocp.entity.User;

/**
 * Created by chocho on 2021/1/2.
 * 用户基础信息
 */
public class VUser extends User {
    //机构名称
    private String orgName;
    //角色名称
    private String actorName;
    //字符性别
    private String ssex;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }
}
