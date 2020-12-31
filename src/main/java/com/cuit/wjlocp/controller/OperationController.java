package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.Actor;
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

    //启用运营账号
    @GetMapping("enableOperation")
    public Msg enable(@RequestParam("username") String username){
        if (username!=null && !username.equals("")){
            iOperationService.enableOperation(username);
            return Msg.success().add("msg", "启用成功！");
        }
        else{
            return Msg.fail().add("msg","启用失败！");
        }
    }

    //禁用运营账号
    @GetMapping("disableOperation")
    public Msg disable(@RequestParam("username") String username){
        if (username!=null && !username.equals("")){
            iOperationService.disableOperation(username);
            return Msg.success().add("msg", "禁用成功！");
        }
        else{
            return Msg.fail().add("msg","禁用失败！");
        }
    }

    //删除运营账号
    @GetMapping("deleteOperation")
    public Msg deleteOperation(@RequestParam("username") String username){
        if (username!=null && !username.equals("")){
            iOperationService.deleteOperation(username);
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
            return Msg.fail().add("msg","添加失败");
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
    
    //模糊查询运营角色
//    @PostMapping()
}
