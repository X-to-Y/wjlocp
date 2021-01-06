package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.Actor;
import com.cuit.wjlocp.entity.Org;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.vo.UserWithName;
import com.github.pagehelper.Page;
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
    Page<UserWithName> selectAllOperation();

    //查询所有运营角色
    @Select("select *\n" +
            "from a_actor\n" +
            "where id > 4")
    Page<Actor> selectAllActor();

    //查询所有所属机构
    @Select("select * \n" +
            "from a_org")
    List<Org> selectAllOrg();

    //模糊查询运营角色
    @Select("<script>" +
            "select *" +
            "from a_actor" +
            "<where>" +
            "and id > 4 " +
            "<if test=\"actorName != \'\'\">" +
            "and actorName like CONCAT('%',#{actorName},'%')" +
            "</if>" +
            "<if test='isFreeze != -1'>" +
            "and isFreeze like CONCAT('%',#{isFreeze},'%')" +
            "</if>" +
            "</where>" +
            "</script>")
    Page<Actor> findActors(Actor actor);

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
    Page<UserWithName> findOperations(UserWithName userWithName);
    
    //启用运营账号
    @Update("update p_user\n" +
            "set isFreeze = 0\n" +
            "where id = #{id}")
    int enableOperation(Integer id);

    //禁用运营账号
    @Update("update p_user\n" +
            "set isFreeze = 1\n" +
            "where id = #{id}")
    int disableOperation(Integer id);

    //删除运营账号
    @Delete("delete\n" +
            "from p_user\n" +
            "where id=#{id}")
    int deleteAccount(Integer id);

    //新增运营角色
    @Insert("insert into a_actor(actorName,memo)\n" +
            "values(#{actorName},#{memo})")
    int addActor(Actor actor);

    //删除运营角色
    @Delete("delete \n" +
            "from a_actor\n" +
            "where id=#{id}")
    int deleteActor(Integer id);

    //启用运营角色
    @Update("update a_actor\n" +
            "set isFreeze = 0\n" +
            "where id = #{id}")
    int enableActor(Integer id);

    //禁用运营角色
    @Update("update a_actor\n" +
            "set isFreeze = 1\n" +
            "where id = #{id}")
    int disableActor(Integer id);

    //新增运营账号
    @Insert("insert into p_user(userName,name,orgType,actorType,sex,tel,mail)\n" +
            "values(#{userName},#{name},#{orgType},#{actorType},#{sex},#{tel},#{mail})")
    int addAccount(User user);

    //修改运营账号信息
    @Update("update p_user\n" +
            "set userName = #{userName} ,name = #{name} ,orgType = #{orgType} ,actorType = #{actorType} ,sex = #{sex} , tel = #{tel}, mail = #{mail}\n" +
            "where id = #{id}")
    int changeAccount(User user);

    //重置密码
    @Update("update p_user\n" +
            "set passWord = '12345'" +
            "where id = #{id}")
    int resetPassword(Integer id);

    //修改角色信息
    @Update("update a_actor\n" +
            "set actorName = #{actorName}, memo = #{memo}\n" +
            "where id = #{id}")
    int changeActorInfo(Actor actor);
}
