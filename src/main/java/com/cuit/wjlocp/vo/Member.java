package com.cuit.wjlocp.vo;

import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.ReceiveInfo;

import java.util.List;

/**
 * Created by chocho on 2021/1/2.
 * 会员信息
 */
public class Member extends Basic {

    //收货地址
    private List<ReceiveInfo> receiveInfoList;



    public List<ReceiveInfo> getReceiveInfoList() {
        return receiveInfoList;
    }

    public void setReceiveInfoList(List<ReceiveInfo> receiveInfoList) {
        this.receiveInfoList = receiveInfoList;
    }
}
