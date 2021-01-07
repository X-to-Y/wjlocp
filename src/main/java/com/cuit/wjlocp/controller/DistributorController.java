package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.entity.ReceiveInfo;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.DistributorServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.Basic;
import com.cuit.wjlocp.vo.DistributorQuery;
import com.cuit.wjlocp.vo.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    //根据经销商id查询子经销商会员信息-基础信息
    @GetMapping("/memeinfo/by/id")
    public Msg getMemeInfoByID(HttpServletRequest request){
        String token = request.getHeader("token");
        List<Basic> basicList = distributorService.getMemberInfoByID(token);
        if(basicList.size() > 0){
            return Msg.success()
                    .add("msg", "查询基础信息成功")
                    .add("data", basicList);
        }else {
            return Msg.fail()
                    .add("msg", "查询基础信息失败");
        }
    }

    //根据基础信息id查询收货地址
    @GetMapping("/address/by/id")
    public Msg getAddressList(@RequestParam Integer baseId){
        List<ReceiveInfo> receiveList = distributorService.getReceiveInfoByID(baseId);
        if(receiveList.size() > 0){
            return Msg.success()
                    .add("msg", "查询收货信息成功")
                    .add("data", receiveList);
        }else {
            return Msg.fail()
                    .add("msg", "查询收货信息失败");
        }
    }

    //根据经销商id查询经销商账户信息
    @GetMapping("/accountinfo/by/id")
    public Msg getAccountInfoByID(@RequestParam String distributorId){
        AccountInfo account = distributorService.getAccountInfoByID(distributorId);
        if(account != null){
            return Msg.success()
                    .add("msg", "查询账户信息成功")
                    .add("data", account);
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
                    .add("data", userList);
        }else {
            return Msg.fail()
                    .add("msg", "查询用户信息失败");
        }
    }

    //模糊查询子经销商用户信息
    @PostMapping("/like/sub/user")
    public Msg getUserInfoByLike(@RequestBody DistributorQuery query){
        List<VUser> userList = distributorService.getUserInfoByLike(query);
        if(userList.size() > 0){
            return Msg.success()
                    .add("msg", "模糊查询用户成功")
                    .add("data", userList);
        }else {
            return Msg.fail()
                    .add("msg", "模糊查询用户失败");
        }
    }

    //新增子经销商用户信息
    @PostMapping("/new/user")
    public Msg addSubUserInfo(@RequestParam String token,
                              @RequestBody User user){
        if(distributorService.addSubUserInfo(token, user)){
            return Msg.success()
                    .add("msg", "新增子经销商成功");
        }else{
            return Msg.fail()
                    .add("msg", "新增子经销商失败");
        }
    }

    //分配子经销商权限接口


    //删除子经销商
    @GetMapping("/delete/sub")
    public Msg removeSubDistributor(@RequestParam Integer subId){
        if(distributorService.removeDistributor(subId)){
            return Msg.success()
                    .add("msg", "删除子经销商成功");
        }else{
            return Msg.fail()
                    .add("msg", "删除子经销商失败");
        }
    }

    //启用子经销商
    @GetMapping("/enable/sub")
    public Msg enableSubDistributor(@RequestParam Integer id){
        if(distributorService.enableDistributor(id)){
            return Msg.success()
                    .add("msg", "启用子经销商成功");
        }else{
            return Msg.fail()
                    .add("msg", "启用子经销商失败");
        }
    }

    //禁用子经销商
    @GetMapping("/disable/sub")
    public Msg disableSubDistributor(@RequestParam Integer id){
        if(distributorService.disableDistributor(id)){
            return Msg.success()
                    .add("msg", "禁用子经销商成功");
        }else{
            return Msg.fail()
                    .add("msg", "禁用子经销商失败");
        }
    }
}
