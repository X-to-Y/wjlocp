package com.cuit.wjlocp.vo;

import com.cuit.wjlocp.entity.BasicInfo;

/**
 * Created by chocho on 2021/1/2.
 */
public class Basic extends BasicInfo {
    //经销商类型
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
