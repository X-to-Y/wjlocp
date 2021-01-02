package com.cuit.wjlocp.service;


import com.cuit.wjlocp.vo.Member;

/**
 * Created by chocho on 2021/1/2.
 * 经销商服务层
 */
public interface DistributorService {
    public Member getMemberInfoByID(String distributorId);
}
