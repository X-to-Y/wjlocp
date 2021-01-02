package com.cuit.wjlocp.service;

import com.cuit.wjlocp.entity.User;

import java.util.List;

/**
 * @author X to Y
 * @date 2021/1/2-12:15
 * 经销商账号管理
 * 服务层
 */
public interface IDtAcctService {

    List<User> selectAllDt();

    List<User> findDt(User user);

    int addDt(User user);


}
