package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.Actor;
import com.cuit.wjlocp.vo.UserWithName;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/25-20:24
 *
 * 运营账号管理模块持久层
 */

@Mapper
@Repository
public interface IOperationDao {


    //查询所有运营账号
    @Select("select *\n" +
            "from p_user u LEFT JOIN a_actor a on u.actorType = a.id LEFT JOIN a_org o on u.orgType = o.id\n" +
            "where actorType >= 4")
    List<UserWithName> selectAllOperation();

    //查询所有运营角色
    @Select("select *\n" +
            "from a_actor\n" +
            "where id > 4")
    List<Actor> selectAllActor();
    
    //启用运营账号
    @Update("update p_user\n" +
            "set isFreeze = 0\n" +
            "where userName = #{userName}")
    int enableOperation(String userName);

    //禁用运营账号
    @Update("update p_user\n" +
            "set isFreeze = 1\n" +
            "where userName = #{userName}")
    int disableOperation(String userName);

    //删除运营账号
    @Delete("delete\n" +
            "from p_user\n" +
            "where userName=#{userName}")
    int deleteOperation(String userName);

    //新增运营角色
    @Insert("insert into a_actor(actorName,memo)\n" +
            "values(#{actorName},#{memo})")
    int addActor(Actor actor);

    //删除运营角色
    @Delete("delete \n" +
            "from a_actor\n" +
            "where actorName=#{actorName}")
    int deleteActor(String actorName);

    //启用运营角色
    @Update("update a_actor\n" +
            "set isFreeze = 0\n" +
            "where actorName = #{actorName}")
    int enableActor(String actorName);

    //禁用运营角色
    @Update("update a_actor\n" +
            "set isFreeze = 1\n" +
            "where actorName = #{actorName}")
    int disableActor(String actorName);

    //模糊查询运营角色
    @Select("<script>" +
            "select *" +
            "from a_actor" +
            "<where>" +
            "<if test=\"actorName != \'\'\">" +
            "and actorName like CONCAT('%',#{actorName},'%')" +
            "</if>" +
            "<if test='isFreeze != -1'>" +
            "and isFreeze like CONCAT('%',#{isFreeze},'%')" +
            "</if>" +
            "</where>" +
            "</script>")
    List<Actor> findActors(Actor actor);

    //模糊查询运营账号
    @Select("<script>" +
            "select *\n" +
            "from p_user u LEFT JOIN a_actor a on u.actorType = a.id LEFT JOIN a_org o on u.orgType = o.id\n" +
            "<where>" +
            "and actorType > 4 " +
            "<if test=\"userName != \'\'\">" +
            "and userName like CONCAT('%',#{userName},'%')" +
            "</if>" +
            "<if test=\"name != \'\'\">" +
            "and name like CONCAT('%',#{name},'%')" +
            "</if>" +
            "<if test=\"tel != \'\'\">" +
            "and tel like CONCAT('%',#{tel},'%')" +
            "</if>" +
            "<if test='isFreeze != -1'>" +
            "and u.isFreeze like CONCAT('%',#{isFreeze},'%')" +
            "</if>" +
            "<if test=\"orgName !=  \'\'\">" +
            "and orgName like CONCAT('%',#{orgName},'%')" +
            "</if>" +
            "<if test='sex != -1'>" +
            "and sex like CONCAT('%',#{sex},'%')" +
            "</if>" +
            "</where>" +
            "</script>")
    List<UserWithName> findOperations(UserWithName userWithName);


}
