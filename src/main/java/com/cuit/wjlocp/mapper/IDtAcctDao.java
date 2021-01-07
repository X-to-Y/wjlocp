package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.DistributorType;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.vo.Basic;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
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
    Page<User> selectAllDt();

    //多条件查询经销商账号信息
    @Select("<script>" +
            "select *" +
            "from p_user" +
            "<where>" +
            "and (actorType = 2 or actorType = 3) " +
            "<if test=\"dtName != \'\'\">" +
            "and dtName like CONCAT('%',#{dtName},'%')" +
            "</if>" +
            "<if test=\"userName != \'\'\">" +
            "and userName like CONCAT('%',#{userName},'%')" +
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
            "set userName=#{userName},dtName=#{dtName},name=#{name},tel=#{tel},mail=#{mail},memo=#{memo}," +
            "   modifyPerson=#{modifyPerson},modifyTime=#{modifyTime}\n" +
            "where id = #{id}")
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

    //经销商类别下拉菜单
    @Select("select *\n" +
            "from d_distributortype")
    List<DistributorType> selectAllDT();

    //经销商列表条件查询
    @Select("<script>" +
            "select *" +
            "from i_basicinfo b left join d_distributortype d on b.distributorType = d.id" +
            "<where>" +
            "<if test=\"distributorName != \'\'\">" +
            "and distributorName like CONCAT('%',#{distributorName},'%')" +
            "</if>" +
            "<if test='distributorType != -1'>" +
            "and distributorType like CONCAT('%',#{distributorType},'%')" +
            "</if>" +
            "<if test=\"distributorNum != \'\'\">" +
            "and distributorNum like CONCAT('%',#{distributorNum},'%')" +
            "</if>" +
            "</where>" +
            "</script>")
    Page<Basic> findDtList(BasicInfo basicInfo);

    //通过basicid查找distributorId
    @Select("select i_distributorinfo.id from i_basicinfo\n" +
            "inner join i_memberinfo on i_basicinfo.id = i_memberinfo.basicId\n" +
            "inner join i_distributorinfo on i_memberinfo.id = i_distributorinfo.memberId\n" +
            "where i_basicinfo.id = #{basicId};")
    Integer findBasicIdByDtId(Integer basicId);

    //关联经销商账号和经销商
    @Insert("insert into p_usertodistributor (distributorId, userId)\n" +
            "values(#{distributorId}, #{userId});")
    Integer relateDtAndAccount(Integer distributorId, Integer userId);

    //解除关联经销商账号和经销商
    @Delete("delete from p_usertodistributor " +
            "where distributorId = #{distributorId} and userId = #{userId};")
    Integer removeRelate(Integer distributorId, Integer userId);

    //判断是否已经关联
    @Select("select count(*) " +
            "from `p_usertodistributor`\n" +
            "where userId = #{userId} and distributorId = #{distributorId}")
    Integer judgeRelated(Integer distributorId, Integer userId);


}
