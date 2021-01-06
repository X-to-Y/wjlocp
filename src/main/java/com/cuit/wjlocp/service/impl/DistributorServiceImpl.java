package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.*;
import com.cuit.wjlocp.mapper.DistributorDao;
import com.cuit.wjlocp.mapper.IUserDao;
import com.cuit.wjlocp.service.DistributorService;
import com.cuit.wjlocp.utils.BaseUtils;
import com.cuit.wjlocp.vo.Basic;
import com.cuit.wjlocp.vo.DistributorQuery;
import com.cuit.wjlocp.vo.Member;
import com.cuit.wjlocp.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by chocho on 2021/1/2.
 * 经销商服务层实现类
 */
@Service
public class DistributorServiceImpl implements DistributorService {
    @Autowired
    private DistributorDao distributorDao;

    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional
    public List<Basic> getMemberInfoByID(String token) {
        if(token == null || "".equals(token)){
            return null;
        }else {
            Basic basic = new Basic();
            //获取基础信息
            Integer userId = userDao.getUserIDByUsername(BaseUtils.convertBase(token));
            return distributorDao.getBasicInfoByID(userId);
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

    @Override
    @Transactional
    public boolean addSubUserInfo(String token, User user) {
        if(user != null){
            //设置默认密码123
            user.setPassWord("12345");
            //启用状态
            user.setIsFreeze(0);
            //创建人名字
            user.setCreatePerson("admin");
            //创建时间
            user.setCreateTime(new Date());
            userDao.addUserInfo(user);
            //获取父用户Id
            String username = BaseUtils.convertBase(token);
            Integer topId = userDao.getUserIDByUsername(username);
            Integer subId = userDao.getUserIDByUsername(user.getUserName());
            if(topId.byteValue() != 0 && subId.byteValue() != 0) {
                TopuserToSubuser tts = new TopuserToSubuser();
                tts.setCreateTime(new Date());
                tts.setTopId(topId);
                tts.setSubId(subId);
                return distributorDao.addTopToSub(tts) > 0;
            }
        }

        return false;
    }

    @Override
    @Transactional
    public boolean removeDistributor(String id) {
        if(id != null && !"".equals(id)){
            return distributorDao.deleteByID(id) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean enableDistributor(Integer id) {
        if(id != null){
            return distributorDao.enableDistributor(id) > 0;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean disableDistributor(Integer id) {
        if(id != null){
            return distributorDao.disableDistributor(id) > 0;
        }
        return false;
    }
}
