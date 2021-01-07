package com.cuit.wjlocp.service;

import com.cuit.wjlocp.entity.Permission;
import com.cuit.wjlocp.mapper.IUserDao;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.vo.DistributorQuery;
import com.cuit.wjlocp.vo.VUser;
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

    //根据token获取角色id
    public List<Permission> getPermissionByToken(String token);

    //修改密码
    public boolean updatePassword(String token, String newPassWord);
}
