package com.cuit.wjlocp.vo;

import com.cuit.wjlocp.entity.User;

/**
 * @author X to Y
 * @date 2020/12/25-20:59
 */
public class UserWithName extends User {
    private String actorName;
    private String orgName;

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "UserWithName{" +
                "actorName='" + actorName + '\'' +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
