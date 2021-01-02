package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.User;
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

    @Select("select * from p_user")
    List<User> getAllUsers();

    @Select("select * from p_user " +
            " where userName = #{username} and isFreeze = 0;")
    User getUserByUsername(String username);

    @Select("select permission from" +
            " p_user inner join a_actor on p_user.actorType = a_actor.id" +
            " inner join a_permission on a_actor.id = a_permission.actorId" +
            " where p_user.userName = #{username};")
    List<String> getPermissionByUsername(String username);
}
