package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.UserService;
import com.cuit.wjlocp.service.impl.UserServiceImpl;
import com.cuit.wjlocp.utils.BaseUtils;
import com.cuit.wjlocp.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Msg Login(@RequestParam String username,
                     @RequestParam String password){

        User user = userService.getUserByUsername(username);

        if (user != null && user.getPassWord() != null && user.getPassWord().equals(password)) {
            return Msg.success()
                    .add("msg", "登录成功")
                    //token 是由用户名加密后所得
                    .add("token", BaseUtils.baseEncode(user.getUserName()));
        }else {
            return Msg.fail()
                    .add("msg", "账户或密码错误");
        }
    }

    /**
     * 获取菜单列表
     * @param request
     * @param response
     * @param token
     * @return
     * @throws Exception
     */
    @GetMapping("/menu/{token}")
    public Msg getMenuByToken(HttpServletRequest request,
                              HttpServletResponse response,
                              @PathVariable("token") String token)throws Exception{
        //根据token得到对应菜单列表
        List<String> permission = userService.getPermissionByToken(token);

        if(permission.size() > 0){
            return Msg.success()
                    .add("msg", "菜单获取成功")
                    .add("menuList", permission);
        }else {
            return Msg.success()
                    .add("msg", "菜单获取失败");
        }
    }
}
