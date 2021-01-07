package com.cuit.wjlocp.service;

import com.cuit.wjlocp.entity.*;
import com.cuit.wjlocp.vo.UserWithName;
import com.github.pagehelper.Page;

import java.util.List;

/**
 *  * @author X to Y
 * @date 2020/12/25-20:31
 *
 * 运营账号管理模块服务层
 */
public interface IOperationService {

    //查询所有运营账号
    public Page<UserWithName> selectAllOpertaion();

    //查询所有运营角色
    public Page<Actor>  selectAllActor();

    //查询所有所属机构
    public List<Org> selectAllOrg();

    //启用运营账号
    public int enableOperation(Integer id);

    //禁用运营账号
    public int disableOperation(Integer id);

    //删除运营账号
    public int deleteAccount(Integer id);

    //新增运营角色
    public int addActor(Actor actor);

    //删除运营角色
    public int deleteActor(Integer id);

    //启用运营角色
    public int enableActor(Integer id);

    //禁用运营角色
    public int disableActor(Integer id);

    //多条件查询运营角色
    public Page<Actor> findActors(Actor actor);

    //多条件查询运营账号
    public Page<UserWithName> findOperations(UserWithName userWithName);

    //新增运营账号
    public int addAccount(User user);

    //修改运营账号信息
    public int changeAccount(User user);

    //重置密码
    public int resetPassword(Integer id);

    //修改角色信息
    public int changeActorInfo(Actor actor);


}