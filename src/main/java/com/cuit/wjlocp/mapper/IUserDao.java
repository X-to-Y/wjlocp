package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/19-13:31
 */
@Mapper
@Repository
public interface IUserDao {

    //查询所有用户
    @Select("select * from p_user")
    List<User> getAllUsers();

    //根据用户名查询启用状态的用户
    @Select("select * from p_user " +
            " where userName = #{username} and isFreeze = 0;")
    User getUserByUsername(String username);

    //获取指定用户对应的菜单列表
    @Select("select permission from" +
            " p_user inner join a_actor on p_user.actorType = a_actor.id" +
            " inner join a_permission on a_actor.id = a_permission.actorId" +
            " where p_user.userName = #{username};")
    List<String> getPermissionByUsername(String username);

    //新增用户信息
    @Insert("insert into p_user (userName, passWord, name, actorType, sex, tel, mail, memo, isFreeze, createTime)" +
            " values(#{userName}, #{passWord}, #{name}, #{actorType}, #{sex}, #{tel}, #{mail}, #{memo}, #{isFreeze}, #{createTime});")
    public int addUserInfo(User user);

    //根据用户名获取用户Id
    @Select("select id from p_user where userName = #{username};")
    public Integer getUserIDByUsername(String username);
}
