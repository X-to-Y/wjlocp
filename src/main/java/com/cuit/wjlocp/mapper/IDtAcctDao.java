package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


/**
 * @author X to Y
 * @date 2021/1/2-12:16
 * 经销商账号管理
 * 持久层
 */
@Mapper
@Repository
public interface IDtAcctDao {

    //获取所有经销商账号
    @Select("select *\n" +
            "from p_user\n" +
            "where actorType = 2 or actorType =3")
    Page<User> selectAllDt();

    //多条件查询经销商账号信息
    @Select("<script>" +
            "select *" +
            "from p_user" +
            "<where>" +
            "and actorType = 2 or actorType = 3 " +
            "<if test=\"dtName != \'\'\">" +
            "and actorName like CONCAT('%',#{dtName},'%')" +
            "</if>" +
            "<if test=\"userName != \'\'\">" +
            "and actorName like CONCAT('%',#{userName},'%')" +
            "</if>" +
            "<if test='isFreeze != -1'>" +
            "and isFreeze like CONCAT('%',#{isFreeze},'%')" +
            "</if>" +
            "</where>" +
            "</script>")
    Page<User> findDt(User user);

    //启用经销商
    @Update("update p_user\n" +
            "set isFreeze = 0\n" +
            "where id = #{id}")
    int enableDt(Integer id);

    //禁用经销商
    @Update("update p_user\n" +
            "set isFreeze = 1\n" +
            "where id = #{id}")
    int disableDt(Integer id);

    //新增经销商账号
    @Insert("insert into p_user(userName,dtName,name,tel,mail,memo,createPerson,modifyPerson,createTime,modifyTime)\n" +
            "values(#{userName},#{dtName},#{name},#{tel},#{mail},#{memo},#{createPerson},#{modifyPerson},#{createTime},#{modifyTime})")
    int addDt(User user);

    //修改经销商账号
    @Update("update p_user \n" +
            "set userName=#{userName},dtName=#{dtName},name={name},tel=#{name},mail=#{mail},memo=#{memp}," +
            "   createPerson=#{createPerson},modifyPerson=#{modifyPerson},createTime=#{createTime},modifyTime=#{modifyTime}\n" +
            "where id = #{user.id}")
    int modifyDt(User user);

    //删除经销商账号
    @Delete("delete\n" +
            "from p_user\n" +
            "where id=#{id}")
    int deleteDt(Integer id);

    //经销商重置密码
    @Update("update p_user\n" +
            "set passWord = '12345'" +
            "where id = #{id}")
    int resetPassword(Integer id);
}
