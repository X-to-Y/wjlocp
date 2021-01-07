package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.Permission;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.UserService;
import com.cuit.wjlocp.service.impl.UserServiceImpl;
import com.cuit.wjlocp.utils.BaseUtils;
import com.cuit.wjlocp.utils.CacheMapUtil;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.utils.ResponseUtil;
import com.cuit.wjlocp.vo.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author chocho
 */
@RestController
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 登录
     * @param loginInfo
     * @return
     */
    @PostMapping("/login")
    public Msg Login(@RequestBody LoginInfo loginInfo){

        User user = userService.getUserByUsername(loginInfo.getUserName());

        if (user != null && user.getPassWord() != null && user.getPassWord().equals(loginInfo.getPassWord())) {
            //将token信息存入缓存
            Map<String, String> map = CacheMapUtil.getInstance();
            String token = BaseUtils.baseEncode(user.getUserName());
            map.put(token, user.getUserName());
            return Msg.success()
                    .add("msg", "登录成功")
                    //token 是由用户名加密后所得
                    .add("token", token)
                    .add("userName", user.getUserName());
        }else {
            return Msg.fail()
                    .add("msg", "账户或密码错误");
        }
    }

    /**
     * 获取菜单列表
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping("/menu")
    public Msg getMenuByToken(HttpServletResponse response,
                              HttpServletRequest request)throws Exception{
        String token = request.getHeader("token");
        if(token == null || "".equals(token)){
            ResponseUtil.returnErrorContent(400, response, "token发生异常");
        }
        //根据token得到对应菜单列表
        List<Permission> permission = userService.getPermissionByToken(token);

        if(permission.size() > 0){
            return Msg.success()
                    .add("msg", "菜单获取成功")
                    .add("data", permission)
                    .add("actorId", permission.get(0).getActorId());
        }else {
            return Msg.success()
                    .add("msg", "菜单获取失败");
        }
    }

    //修改密码
    @GetMapping("/update/password")
    public Msg updatePassword(HttpServletRequest request,
                              @RequestParam String oldPassWord,
                              @RequestParam String newPassWord){
        String token = request.getHeader("token");
        //用户校验
        User user = userService.getUserByUsername(BaseUtils.convertBase(token));
        if(user != null){
            if(!user.getPassWord().equals(oldPassWord)){
                return Msg.fail()
                        .add("msg", "旧密码输入错误");
            }else {
                if (userService.updatePassword(token, newPassWord)) {
                    return Msg.success()
                            .add("msg", "修改密码成功");
                } else {
                    return Msg.success()
                            .add("msg", "修改密码失败");
                }
            }
        }
        return null;
    }

    /**
     * 注销登录
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public Msg logOut(HttpServletRequest request){
        Map<String, String> map = CacheMapUtil.getInstance();
        String token = request.getHeader("token");
        map.remove(token);

        if (map.get(token) == null || "".equals(map.get(token))) {
            return Msg.success().add("msg","成功登出");
        }else {
            return Msg.fail().add("msg","登出失败");
        }
    }
}
