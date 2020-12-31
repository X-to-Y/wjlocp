package com.cuit.wjlocp.entity;

import javax.persistence.Entity;

/**
 * @author X to Y
 * @date 2020/12/31-15:23
 *
 * 运营账号所属机构类型
 */
@Entity
public class Org {
    private int id;

    private String orgName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "Org{" +
                "id=" + id +
                ", orgName='" + orgName + '\'' +
                '}';
    }
}
