package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.Permission;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.IUserDao;
import com.cuit.wjlocp.service.UserService;
import com.cuit.wjlocp.utils.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by chocho on 2020/12/31.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;

    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        if(username != null && !"".equals(username)){
            return userDao.getUserByUsername(username);
        }else{
            return null;
        }
    }

    @Override
    @Transactional
    public List<Permission> getPermissionByToken(String token) {
        String username = BaseUtils.convertBase(token);
        Integer actorType = userDao.getActorTypeByUsername(username);
        if(actorType >= 4) {//运营
            return userDao.getPermissionByActorId(4);
        }else {//经销商
            return userDao.getPermissionByActorId(2);
        }
    }

    @Override
    @Transactional
    public boolean updatePassword(String token, String newPassWord) {
        String username = BaseUtils.convertBase(token);
        Integer userId = userDao.getUserIDByUsername(username);
        return userDao.updatePassword(userId, newPassWord) > 0;
    }
}
