package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.IDtAcctDao;
import com.cuit.wjlocp.service.IDtAcctService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author X to Y
 * @date 2021/1/2-12:15
 * 经销商账号管理
 * 服务层
 */
@Service
public class IDtAcctServiceImpl implements IDtAcctService {

    @Autowired
    IDtAcctDao iDtAcctDao;

    //获取所有经销商账号
    @Override
    public List<User> selectAllDt() {
        return iDtAcctDao.selectAllDt();
    }

    //多条件查询经销商账号信息
    @Override
    public List<User> findDt(User user) {
        return iDtAcctDao.findDt(user);
    }

    @Override
    public int addDt(User user) {
        return iDtAcctDao.addDt(user);
    }
}
