package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.MemberInfo;
import com.cuit.wjlocp.entity.ReceiveInfo;
import com.cuit.wjlocp.mapper.DistributorDao;
import com.cuit.wjlocp.service.DistributorService;
import com.cuit.wjlocp.vo.Basic;
import com.cuit.wjlocp.vo.DistributorQuery;
import com.cuit.wjlocp.vo.Member;
import com.cuit.wjlocp.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chocho on 2021/1/2.
 * 经销商服务层实现类
 */
@Service
public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private DistributorDao distributorDao;

    @Override
    @Transactional
    public Member getMemberInfoByID(String distributorId) {
        if(distributorId == null || "".equals(distributorId)){
            return null;
        }else {
            Member member = new Member();
            //获取基础信息
            Basic basic = distributorDao.getBasicInfoByID(distributorId);
            if(basic != null ){
                member.setId(basic.getId());
                member.setDistributorName(basic.getDistributorName());
                member.setDistributorNum(basic.getDistributorNum());
                member.setDistributorSubName(basic.getDistributorSubName());
                member.setOrgName(basic.getOrgName());
                member.setName(basic.getName());
                member.setMemo(basic.getMemo());
            }
            //获取收货地址
            List<ReceiveInfo> receiveInfoList = distributorDao.getReceiveInfoByID(distributorId);
            if(receiveInfoList.size() > 0){
                member.setReceiveInfoList(receiveInfoList);
            }

            return member;
        }
   }

    @Override
    @Transactional
    public AccountInfo getAccountInfoByID(String distributorId) {
        if(distributorId != null && !"".equals(distributorId)) {
            AccountInfo account = distributorDao.getAccountInfo(distributorId);
            if(account != null){
                return account;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public List<VUser> getUserInfoByTopID(String topId) {
        if(topId != null && !"".equals(topId)){
            List<VUser> userList = distributorDao.getUserInfoByTopId(topId);
            return userList;
        }
        return null;
    }

    @Override
    @Transactional
    public List<VUser> getUserInfoByLike(DistributorQuery query) {
        return distributorDao.getUserInfoByLike(query);
    }
}
