package com.cuit.wjlocp.service;


import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.entity.ReceiveInfo;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.vo.Basic;
import com.cuit.wjlocp.vo.DistributorQuery;
import com.cuit.wjlocp.vo.Member;
import com.cuit.wjlocp.vo.VUser;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by chocho on 2021/1/2.
 * 经销商服务层
 */
public interface DistributorService {
    //根据经销商id查询会员信息
    public List<Basic> getMemberInfoByID(String token);

    //根据经销商id查询账户信息
    public List<AccountInfo> getAccountInfoByToken(String token);

    //根据父经销商获取子经销商用户信息
    public List<VUser> getUserInfoByTopID(String topId);

    //模糊查询用户信息
    public Page<VUser> getUserInfoByLike(String token, DistributorQuery query);

    //新增子经销商信息
    public boolean addSubUserInfo(String token, User user);

    //删除经销商
    public boolean removeDistributor(Integer id);

    //启用经销商
    public boolean enableDistributor(Integer id);

    //禁用经销商
    public boolean disableDistributor(Integer id);

    //根据基础信息id获取收货信息
    public List<ReceiveInfo> getReceiveInfoByID(Integer baseId);

    //更新经销商
    public boolean updateDistributor(User user);
}
