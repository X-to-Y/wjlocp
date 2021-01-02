package com.cuit.wjlocp.service;

import com.cuit.wjlocp.mapper.IUserDao;
import com.cuit.wjlocp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/19-16:27
 */
public interface UserService {
    //获取所有用户
    public List<User> getAllUser();

    //根据用户名获取用户信息
    public User getUserByUsername(String username);
}
