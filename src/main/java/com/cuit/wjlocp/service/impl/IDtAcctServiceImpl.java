package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.IDtAcctDao;
import com.cuit.wjlocp.service.IDtAcctService;
import com.cuit.wjlocp.utils.BaseUtils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public Page<User> selectAllDt() {
        return iDtAcctDao.selectAllDt();
    }

    //多条件查询经销商账号信息
    @Override
    public Page<User> findDt(User user) {
        return iDtAcctDao.findDt(user);
    }

    //启用经销商
    @Override
    public int enableDt(Integer id) {
        return iDtAcctDao.enableDt(id);
    }

    //禁用经销商
    @Override
    public int disableDt(Integer id) {
        return iDtAcctDao.disableDt(id);
    }

    //新增经销商
    @Override
    public int addDt(User user, String token){
        String name = BaseUtils.convertBase(token);
        user.setCreatePerson(name);
        user.setModifyPerson(name);
        Date date = new Date();
        user.setCreateTime(date);
        user.setModifyTime(date);
        return iDtAcctDao.addDt(user);
    }

    //修改经销商信息
    @Override
    public int modifyDt(User user, String token) {
        String name = BaseUtils.convertBase(token);
        user.setModifyPerson(name);
        Date date = new Date();
        user.setModifyTime(date);
        return iDtAcctDao.modifyDt(user);
    }

    //删除经销商
    @Override
    public int deleteDt(Integer id) {
        return iDtAcctDao.deleteDt(id);
    }

    //重置密码
    @Override
    public int resetPassword(Integer id) {
        return iDtAcctDao.resetPassword(id);
    }

}
