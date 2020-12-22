package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/18-22:22
 */
@RestController
public class test {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello World";
    }

    @RequestMapping("/users")
    public List<User> allUsers(){
        return userService.getAllUser();
    }
}
