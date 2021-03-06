package com.cuit.wjlocp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.cuit.wjlocp.mapper")
@EnableScheduling
@EnableTransactionManagement
@CrossOrigin
public class WjlocpApplication {


    public static void main(String[] args) {


        SpringApplication.run(WjlocpApplication.class, args);
    }
}
