package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.AccountInfo;
import com.cuit.wjlocp.entity.ReceiveInfo;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.DistributorServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.Basic;
import com.cuit.wjlocp.vo.DistributorQuery;
import com.cuit.wjlocp.vo.UserWithName;
import com.cuit.wjlocp.vo.VUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public Msg getAccountInfoByID(HttpServletRequest request){
        String token = request.getHeader("token");
        List<AccountInfo> account = distributorService.getAccountInfoByToken(token);
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
    public Msg getUserInfoByLike(HttpServletRequest request,
                                 @RequestBody DistributorQuery query){
        String token = request.getHeader("token");
        String pageParam = request.getHeader("pageParam");
        String limitParam = request.getHeader("limitParam");

        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<VUser> userList = distributorService.getUserInfoByLike(token, query);
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",userList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<VUser> userList = distributorService.getUserInfoByLike(token, query);
            if(userList.size() > 0){
                return Msg.success()
                        .add("msg",  "模糊查询用户成功！")
                        .add("data",userList)
                        .add("page",Integer.parseInt(pageParam))
                        .add("totalPage",((userList.getTotal()-1)/(Integer.parseInt(limitParam)))+1);
            }else {
                return Msg.fail()
                        .add("msg", "模糊查询用户失败");
            }
        }
    }

    //新增子经销商用户信息
    @PostMapping("/new/user")
    public Msg addSubUserInfo(HttpServletRequest request,
                              @RequestBody User user){
        String token = request.getHeader("token");
        if(distributorService.addSubUserInfo(token, user)){
            return Msg.success()
                    .add("msg", "新增子经销商成功");
        }else{
            return Msg.fail()
                    .add("msg", "新增子经销商失败");
        }
    }

    //修改经销商信息
    @PostMapping("/update")
    public Msg updateDistributor(@RequestBody User user){
        if(distributorService.updateDistributor(user)){
            return Msg.success()
                    .add("msg", "修改经销商信息成功");
        }else{
            return Msg.fail()
                    .add("msg", "修改经销商信息失败");
        }
    }


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
