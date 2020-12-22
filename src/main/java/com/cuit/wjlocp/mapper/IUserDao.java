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

}
