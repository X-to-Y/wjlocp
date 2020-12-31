package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.UserService;
import com.cuit.wjlocp.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chocho
 */
@RestController("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @PostMapping
    public Msg Login(@RequestParam String username,
                     @RequestParam String password){
        User user = userService.getUserByUsername(username);
        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            return Msg.success().add("msg", "登录成功");
        } else {
            return Msg.fail().add("msg", "账户或密码错误");
        }
    }
}
