package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.DistributorType;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.DistributorDao;
import com.cuit.wjlocp.mapper.IDtAcctDao;
import com.cuit.wjlocp.service.IDtAcctService;
import com.cuit.wjlocp.utils.BaseUtils;
import com.cuit.wjlocp.vo.Basic;
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

    @Autowired
    DistributorDao distributorDao;


    @Override
    public Page<User> selectAllDt() {
        return iDtAcctDao.selectAllDt();
    }


    @Override
    public Page<User> findDt(User user) {
        return iDtAcctDao.findDt(user);
    }


    @Override
    public int enableDt(Integer id) {
        return iDtAcctDao.enableDt(id);
    }


    @Override
    public int disableDt(Integer id) {
        return iDtAcctDao.disableDt(id);
    }

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

    @Override
    public int modifyDt(User user, String token) {
        String name = BaseUtils.convertBase(token);
        user.setModifyPerson(name);
        Date date = new Date();
        user.setModifyTime(date);
        System.out.println(user);
        return iDtAcctDao.modifyDt(user);
    }


    @Override
    public int deleteDt(Integer id) {
        return iDtAcctDao.deleteDt(id);
    }

    @Override
    public int resetPassword(Integer id) {
        return iDtAcctDao.resetPassword(id);
    }

    @Override
    public List<DistributorType> selectAllDT() {
        return iDtAcctDao.selectAllDT();
    }

    @Override
    public Page<Basic> findDtList(BasicInfo basicInfo) {
        if (null == basicInfo.getDistributorType()){
             basicInfo.setDistributorType(-1);
//            System.out.println(basicInfo);
        }
        return iDtAcctDao.findDtList(basicInfo);
    }

    @Override
    public int relate(Integer basicId, Integer userId) {
        int  distributorId = iDtAcctDao.findBasicIdByDtId(basicId);
        if (1 == iDtAcctDao.judgeRelated(distributorId,userId)){
            return -1;
        }
        return iDtAcctDao.relateDtAndAccount(distributorId,userId);
    }

    @Override
    public int remove(Integer basicId, Integer userId) {
        int  distributorId = iDtAcctDao.findBasicIdByDtId(basicId);
        return iDtAcctDao.removeRelate(distributorId,userId);
    }

    @Override
    public List<Basic> relatedList(Integer userId) {
        return distributorDao.getBasicInfoByID(userId);
    }
}
