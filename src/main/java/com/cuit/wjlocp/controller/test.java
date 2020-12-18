package com.cuit.wjlocp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author X to Y
 * @date 2020/12/18-22:22
 */
@RestController
public class test {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello World";
    }
}
