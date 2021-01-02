package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.Actor;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.IOperationServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.UserWithName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/25-20:21
 *
 * 运营账号管理类
 * 控制层
 */


@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private IOperationServiceImpl iOperationService;

    //查询所有运营账号信息；
    @GetMapping("/allAccount")
    public Msg selectAllOperation(){
        return Msg.success().add("msg",iOperationService.selectAllOpertaion());
    }

    //查询所有运营角色
    @GetMapping("/allActor")
    public Msg selectAllActor(){
        return Msg.success().add("msg",iOperationService.selectAllActor());
    }

    //查询所有所属机构
    @GetMapping("allOrg")
    public Msg selectAllOrg(){  return Msg.success().add("msg",iOperationService.selectAllOrg()); }

    //启用运营账号
    @GetMapping("enableOperation")
    public Msg enable(@RequestParam("userName") String userName){
        if (userName!=null && !userName.equals("")){
            iOperationService.enableOperation(userName);
            return Msg.success().add("msg", "启用成功！");
        }
        else{
            return Msg.fail().add("msg","启用失败！");
        }
    }

    //禁用运营账号
    @GetMapping("disableOperation")
    public Msg disable(@RequestParam("userName") String userName){
        if (userName!=null && !userName.equals("")){
            iOperationService.disableOperation(userName);
            return Msg.success().add("msg", "禁用成功！");
        }
        else{
            return Msg.fail().add("msg","禁用失败！");
        }
    }

    //删除运营账号
    @GetMapping("deleteAccount")
    public Msg deleteOperation(@RequestParam("userName") String username){
        if (username!=null && !username.equals("")){
            iOperationService.deleteAccount(username);
            return Msg.success().add("msg", "删除成功！");
        }
        else{
            return Msg.fail().add("msg","删除失败！");
        }
    }

    //新增运营角色
    @PostMapping("addActor")
    public Msg addActor(@RequestBody Actor actor){
//        System.out.println(actor);
        if (actor != null){
//            actor.setIsFreeze(0);
            iOperationService.addActor(actor);
            return Msg.success().add("msg","新增成功！");
        }
        else{
            return Msg.fail().add("msg","新增失败");
        }
    }

    //删除运营角色
    @GetMapping("deleteActor")
    public Msg deleteActor(@RequestParam String actorName){
        if (actorName!=null && !actorName.equals("")){
            iOperationService.deleteActor(actorName);
            return Msg.success().add("msg", "删除成功！");
        }
        else{
            return Msg.fail().add("msg","删除失败！");
        }
    }

    //启用运营角色
    @GetMapping("enableActor")
    public Msg enableActor(@RequestParam String actorName){
        if (actorName!=null && !actorName.equals("")){
            iOperationService.enableActor(actorName);
            return Msg.success().add("msg", "启用成功！");
        }
        else{
            return Msg.fail().add("msg","启用失败！");
        }
    }

    //禁用运营角色
    @GetMapping("disableActor")
    public Msg disableActor(@RequestParam String actorName){
        if (actorName!=null && !actorName.equals("")){
            iOperationService.disableActor(actorName);
            return Msg.success().add("msg", "禁用成功！");
        }
        else{
            return Msg.fail().add("msg","禁用失败！");
        }
    }
    
    //多条件查询运营角色
    @PostMapping("findActors")
    public Msg findActors(@RequestBody Actor actor){
        if (actor != null) {
            return Msg.success().add("msg",iOperationService.findActors(actor));
        }
        else{
            return Msg.fail().add("msg","参数出错");
        }
    }

    //多条件查询运营角色
    @PostMapping("findOperations")
    public Msg findOperations(@RequestBody UserWithName userWithName){
        if (userWithName != null) {
            return Msg.success().add("msg",iOperationService.findOperations(userWithName));
        }
        else{
            return Msg.fail().add("msg","参数出错");
        }
    }

    //新增运营账号
    @PostMapping("addAccount")
    public Msg addAccount(@RequestBody User user){
        if (user != null){
            iOperationService.addAccount(user);
            return Msg.success().add("msg","新增成功！");
        }
        else{
            return Msg.fail().add("msg","新增失败");
        }
    }

    //修改运营账号信息
    @PostMapping("changeAccount")
    public Msg changeAccount(@RequestBody User user){
        if (user != null){
            iOperationService.changeAccount(user);
            return Msg.success().add("msg","修改成功！");
        }
        else{
            return Msg.fail().add("msg","修改失败");
        }
    }

    //重置密码
    @GetMapping("resetPassword")
    public Msg resetPassword(@RequestParam String userName){
        if (userName != null && !userName.equals("")) {
            iOperationService.resetPassword(userName);
            return Msg.success().add("msg","重置密码成功！");
        }
        else {
            return Msg.fail().add("msg","重置密码失败！");
        }
    }

    //修改角色信息
    @PostMapping("changeActorInfo")
    public Msg changeActorInfo(@RequestBody Actor actor){
        if (actor != null && !actor.equals("")) {
            iOperationService.changeActorInfo(actor);
            return Msg.success().add("msg","修改信息成功！");
        }
        else {
            return Msg.fail().add("msg","修改信息失败！");
        }
    }
}
