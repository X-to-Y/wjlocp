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
@Service
public class UserService {

    @Autowired
    private IUserDao iuserdao;

    public List<User> getAllUser(){
        return iuserdao.getAllUsers();
    }


}
