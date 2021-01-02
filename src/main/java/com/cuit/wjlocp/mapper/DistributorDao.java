package com.cuit.wjlocp.mapper;

import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.MemberInfo;
import com.cuit.wjlocp.entity.ReceiveInfo;
import com.cuit.wjlocp.vo.Basic;
import com.cuit.wjlocp.vo.VUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chocho on 2021/1/2.
 * 经销商持久化层
 */
@Mapper
@Repository
public interface DistributorDao {
    //根据经销商id查询收货信息
    @Select("select * from " +
            " i_distributorinfo inner join i_memberinfo on i_distributorinfo.memberId = i_memberinfo.id" +
            " left join i_receiveinfo on i_receiveinfo.id =  i_memberinfo.receiveId " +
            " where i_distributorinfo.id = #{distributorId}")
    public List<ReceiveInfo> getReceiveInfoByID(String distributorId);

    //根据经销商id查询基础信息
    @Select("select i_basicinfo.id, distributorName, distributorNum, distributorSubName, orgName, d_distributortype.name, memo from " +
            " i_distributorinfo inner join i_memberinfo on i_distributorinfo.memberId = i_memberinfo.id" +
            " inner join i_basicinfo on i_basicinfo.id =  i_memberinfo.basicId " +
            " left join d_distributortype on d_distributortype.id = i_basicinfo.distributorType" +
            " where i_distributorinfo.id = #{distributorId}")
    public Basic getBasicInfoByID(String distributorId);

    //根据经销商id查询账户信息
    @Select("select * from" +
            " i_distributorinfo inner join i_accountinfo on i_distributorinfo.accountId = i_accountinfo.id" +
            " where i_distributorinfo.id = #{distributorId}")
    public AccountInfo getAccountInfo(String distributorId);

    //根据父经销商id获取子经销商用户信息
    @Select("select p2.id, p2.userName, p2.passWord, p2.name, p2.sex, p2.memo, a_org.orgName, p2.mail, p2.tel, p2.isFreeze, p2.dtName, p2.createPerson, p2.createTime, p2.modifyPerson, p2.modifyTime from " +
            " d_topusertosubuser inner join p_user p1 on d_topusertosubuser.topId = p1.id" +
            " left join p_user p2 on d_topusertosubuser.subId = p2.id" +
            " left join a_org on p2.orgType = a_org.id" +
            " where d_topusertosubuser.topId = #{topId}")
    public List<VUser> getUserInfoByTopId(String topId);
}
