package com.cuit.wjlocp.vo;

import com.cuit.wjlocp.entity.User;

/**
 * Created by chocho on 2021/1/2.
 * 用户基础信息
 */
public class VUser extends User {
    //机构名称
    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
