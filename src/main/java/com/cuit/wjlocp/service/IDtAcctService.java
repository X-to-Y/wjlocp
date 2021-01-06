package com.cuit.wjlocp.service;

import com.cuit.wjlocp.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author X to Y
 * @date 2021/1/2-12:15
 * 经销商账号管理
 * 服务层
 */
public interface IDtAcctService {


    Page<User> selectAllDt();

    Page<User> findDt(User user);

    int enableDt(Integer id);

    int disableDt(Integer id);

    int addDt(User user, String token);

    int modifyDt(User user, String token);

    int deleteDt(Integer id);

    int resetPassword(Integer id);




}
