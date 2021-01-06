package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.IDtAcctServiceImpl;
import com.cuit.wjlocp.utils.BaseUtils;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.UserWithName;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author X to Y
 * @date 2021/1/2-12:14
 * 经销商账号管理
 * 控制层
 */
@RestController
@RequestMapping("/dtAcct")
public class DtAcctController {

    @Autowired
    IDtAcctServiceImpl iDtAcctServiceImpl;

    /***
     * 获取所有经销商账号
     * @return
     */
    @GetMapping("allAccount")
    public Msg selectAllDt(@RequestParam String pageParam,
                           @RequestParam String limitParam){
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<User> usersList = iDtAcctServiceImpl.selectAllDt();
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",usersList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<User> usersList = iDtAcctServiceImpl.selectAllDt();
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",usersList)
                    .add("page",pageParam)
                    .add("totalPage",(usersList.getTotal()/(Integer.parseInt(limitParam)))+1);
        }
    }

    /***
     * 多条件查询经销商账号
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("findAccount")
    public Msg findDt(@RequestBody User user,
                      HttpServletRequest request){
        String pageParam = request.getHeader("pageParam");
        String limitParam = request.getHeader("limitParam");
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<User> usersList = iDtAcctServiceImpl.findDt(user);
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",usersList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<User> usersList = iDtAcctServiceImpl.findDt(user);
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",usersList)
                    .add("page",pageParam)
                    .add("totalPage",(usersList.getTotal()/(Integer.parseInt(limitParam)))+1);
        }
    }

    /***
     * 启用经销商账号
     * @param id
     * @return
     */
    @GetMapping("enableDt")
    public Msg enableDt(@RequestParam Integer id){

        if(id != 0){
            int flag = iDtAcctServiceImpl.enableDt(id);
            if (1 == flag) {
                return Msg.success().add("msg", "启用成功！");
            }else{
                return Msg.fail().add("msg", "启用失败！");
            }
        }else{
            return Msg.fail().add("msg", "参数有误！");
        }

    }

    /***
     * 禁用经销商账号
     * @param id
     * @return
     */
    @GetMapping("disableDt")
    public Msg disableDt(@RequestParam Integer id){

         if(id != 0){
             int flag = iDtAcctServiceImpl.disableDt(id);
             if (1 == flag) {
                 return Msg.success().add("msg", "禁用成功！");
             }else{
                 return Msg.fail().add("msg", "禁用失败！");
             }
         }else{
             return Msg.fail().add("msg", "参数有误！");
        }

    }

    /***
     * 新增经销商账号
     * 未完成
     * @param user
     * @return
     */
    @PostMapping("addDt")
    public Msg addDt(@RequestBody User user,
                     HttpServletRequest request){
        String token = request.getHeader("token");
        System.out.println(token);
        if(user != null && !token.equals("")){
            int flag = iDtAcctServiceImpl.addDt(user,token);
            if (1 == flag){
                return Msg.success().add("msg","新增账号成功！");
            }else{
                return Msg.fail().add("msg","新增账号失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    @PostMapping("modifyDt")
    public Msg modifyDt(@RequestBody User user,
                        HttpServletRequest request){
        String token = request.getHeader("token");
        if(user != null && !token.equals("")){
            int flag = iDtAcctServiceImpl.addDt(user,token);
            if (1 == flag){
                return Msg.success().add("msg","修改信息成功！");
            }else{
                return Msg.fail().add("msg","修改信息失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }

    }

    /***
     * 删除经销商账号
     * @param id
     * @return
     */
    @PostMapping("deleteDt")
    public Msg deleteDt(@RequestParam Integer id){

        if(id != 0){
            int flag = iDtAcctServiceImpl.deleteDt(id);
            if (1 == flag){
                return Msg.success().add("msg", "删除账号成功！");
            }else{
                return Msg.fail().add("msg","删除账号失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 重置经销商账号密码
     * @param id
     * @return
     */
    @GetMapping("resetPassWord")
    public Msg resetPassword(Integer id){
        if (id != 0){
            int flag = iDtAcctServiceImpl.resetPassword(id);
            if (1 == flag){
                return Msg.success().add("msg", "重置密码成功！");
            }else{
                return Msg.fail().add("msg","重置密码失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }


}
