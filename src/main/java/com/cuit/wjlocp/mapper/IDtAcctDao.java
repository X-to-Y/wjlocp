package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    List<User> selectAllDt();

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
    List<User> findDt(User user);

    //新增经销商账号
    @Insert("insert into p_user(userName,dtName,name,tel,mail,memo)\n" +
            "values(#{userName},#{#dtName},#{name},#{tel},#{mail},#{memo})")
    int addDt(User user);
}
