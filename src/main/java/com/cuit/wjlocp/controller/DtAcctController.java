package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.IDtAcctServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Msg selectAllDt(){
        List<User> users = iDtAcctServiceImpl.selectAllDt();
        if (users.size() > 0) {
            return Msg.success().add("msg", users);
        }else{
            return Msg.fail().add("msg", "未找到任何经销商！");
        }
    }

    /***
     * 多条件查询经销商账号
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("findAccount")
    public Msg findDt(@RequestBody User user) throws Exception{
        List<User> users = iDtAcctServiceImpl.findDt(user);
        if (users.size() > 0) {
            System.out.println(new Date());
            //时间转换，通过注解已解决
//            for(User u : users) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                System.out.println(sdf.parse(sdf.format(u.getCreateTime())));
////                u.setCreateTime(sdf.parse(sdf.format(u.getCreateTime())));
//                u.setModifyTime(sdf.parse(sdf.format(u.getModifyTime())));
//
//                System.out.println(u);
//            }
            return Msg.success().add("msg", users);
        }else{
            return Msg.fail().add("msg", "未找到任何经销商！");
        }
    }


}
