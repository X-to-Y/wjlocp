package com.cuit.wjlocp.service;


import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.vo.Member;

/**
 * Created by chocho on 2021/1/2.
 * 经销商服务层
 */
public interface DistributorService {
    //根据经销商id查询会员信息
    public Member getMemberInfoByID(String distributorId);

    //根据经销商id查询账户信息
    public AccountInfo getAccountInfoByID(String distributorId);
}
