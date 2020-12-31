package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.IUserDao;
import com.cuit.wjlocp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by chocho on 2020/12/31.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByUsername(String username) {
        if(username != null && !"".equals(username)){
            return userDao.getUserByUsername(username);
        }else{
            return null;
        }
    }
}
