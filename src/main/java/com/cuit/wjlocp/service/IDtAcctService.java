package com.cuit.wjlocp.service;

import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.DistributorType;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.vo.Basic;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author X to Y
 * @date 2021/1/2-12:15
 * 经销商账号管理
 * 服务层
 */
public interface IDtAcctService {


    //获取所有经销商账号
    Page<User> selectAllDt();

    //多条件查询经销商账号信息
    Page<User> findDt(User user);

    //启用经销商
    int enableDt(Integer id);

    //禁用经销商
    int disableDt(Integer id);

    //新增经销商
    int addDt(User user, String token);

    //修改经销商信息
    int modifyDt(User user, String token);

    //删除经销商
    int deleteDt(Integer id);

    //重置密码
    int resetPassword(Integer id);

    //经销商类别下拉菜单
    public List<DistributorType> selectAllDT();

    //经销商列表条件查询
    Page<Basic> findDtList(BasicInfo basicInfo);

    //关联经销商列表
    int relate(Integer basicId, Integer userId);

    //解除关联
    int remove(Integer basicId, Integer userId);

    //获取已关联的经销商列表
    List<Basic> relatedList(Integer userId);

}
