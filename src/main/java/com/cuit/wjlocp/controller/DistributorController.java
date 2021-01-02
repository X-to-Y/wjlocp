package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.entity.MemberInfo;
import com.cuit.wjlocp.service.DistributorService;
import com.cuit.wjlocp.service.impl.DistributorServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.Member;
import com.cuit.wjlocp.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chocho on 2021/1/2.
 * 经销商管理
 * 控制层
 */
@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    private DistributorServiceImpl distributorService;

    //根据经销商id查询经销商会员信息
    @GetMapping("/memeinfo/by/id")
    public Msg getMemeInfoByID(@RequestParam String distributorId){
        Member member = distributorService.getMemberInfoByID(distributorId);
        if(member != null){
            return Msg.success()
                    .add("msg", "查询会员信息成功")
                    .add("memberInfo", member);
        }else {
            return Msg.fail()
                    .add("msg", "查询会员信息失败");
        }
    }

    //根据经销商id查询经销商账户信息
    @GetMapping("/accountinfo/by/id")
    public Msg getAccountInfoByID(@RequestParam String distributorId){
        AccountInfo account = distributorService.getAccountInfoByID(distributorId);
        if(account != null){
            return Msg.success()
                    .add("msg", "查询账户信息成功")
                    .add("accountInfo", account);
        }else {
            return Msg.fail()
                    .add("msg", "查询账户信息失败");
        }
    }

    //查询指定经销商所有子经销商用户信息
    @GetMapping("/user/by/topId")
    public Msg getUserInfoByTopID(@RequestParam String topId){
        List<VUser> userList = distributorService.getUserInfoByTopID(topId);
        if(userList.size() > 0){
            return Msg.success()
                    .add("msg", "查询用户信息成功")
                    .add("userList", userList);
        }else {
            return Msg.fail()
                    .add("msg", "查询用户信息失败");
        }
    }
}
