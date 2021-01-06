package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.Permission;
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
//@Mapper
//@Repository
public interface IUserDao {

    //查询所有用户
    @Select("select * from p_user")
    List<User> getAllUsers();

    //根据用户名查询启用状态的用户
    @Select("select * from p_user " +
            " where userName = #{username} and isFreeze = 0;")
    User getUserByUsername(String username);

    //获取对应的菜单列表
    @Select("select * from a_permission where actorId = #{actorId}")
    List<Permission> getPermissionByActorId(Integer actorId);

    //新增用户信息
    @Insert("insert into p_user (userName, passWord, name, actorType, sex, tel, mail, memo, isFreeze, createTime)" +
            " values(#{userName}, #{passWord}, #{name}, #{actorType}, #{sex}, #{tel}, #{mail}, #{memo}, #{isFreeze}, #{createTime});")
    public int addUserInfo(User user);

    //根据用户名获取用户Id
    @Select("select id from p_user where userName = #{username};")
    public Integer getUserIDByUsername(String username);

    //根据用户名获取角色id
    @Select("select actorType from p_user where userName = #{userName}")
    public Integer getActorTypeByUsername(String username);

    //根据用户名获取经销商id
    @Select("select i_distributorinfo.id from p_user" +
            " left join p_usertodistributor on p_user.id = p_usertodistributor.userId" +
            " left join i_distributorinfo on p_usertodistributor.distributorId = i_distributorinfo.id" +
            " where p_user.userName = #{username};")
    public Integer getDistributorIDByUsername(String username);

}
