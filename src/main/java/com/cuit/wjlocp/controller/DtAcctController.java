package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.BasicInfo;
import com.cuit.wjlocp.entity.DistributorType;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.IDtAcctServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.Basic;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
                    .add("page",Integer.parseInt(pageParam))
                    .add("totalPage",((usersList.getTotal() - 1)/(Integer.parseInt(limitParam)))+1);
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
        System.out.println(limitParam);
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
                    .add("page",Integer.parseInt(pageParam))
                    .add("totalPage",((usersList.getTotal() - 1)/(Integer.parseInt(limitParam)))+1);
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

    /***
     * 修改经销商账号信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping("modifyDt")
    public Msg modifyDt(@RequestBody User user,
                        HttpServletRequest request){
        String token = request.getHeader("token");
        if(user != null && !token.equals("")){
            int flag = iDtAcctServiceImpl.modifyDt(user,token);
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
    @GetMapping("deleteDt")
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

    /***
     * 经销商类别下拉列表接口
     * @return
     */
    @GetMapping("allDt")
    public Msg selectDt(){
        List<DistributorType> DTList = iDtAcctServiceImpl.selectAllDT();
        if (DTList!=null){
            return Msg.success().add("msg","查询成功！")
                    .add("data",DTList);
        }else{
            return Msg.fail().add("msg","未查到任何信息！");
        }
    }

    /***
     * 多条件分页查询
     * @param basicInfo
     * @param request
     * @return
     */
    @PostMapping("findDtList")
    public Msg findDtList(@RequestBody BasicInfo basicInfo,
                      HttpServletRequest request){
        String pageParam = request.getHeader("pageParam");
        String limitParam = request.getHeader("limitParam");
//        System.out.println(basicInfo);
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<Basic> basicInfoList = iDtAcctServiceImpl.findDtList(basicInfo);
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",basicInfoList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<Basic> basicInfoList = iDtAcctServiceImpl.findDtList(basicInfo);
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",basicInfoList)
                    .add("page",Integer.parseInt(pageParam))
                    .add("totalPage",((basicInfoList.getTotal() - 1)/(Integer.parseInt(limitParam)))+1);
        }
    }

    /***
     * 关联经销商和经销商账号
     * @param basicId
     * @param userId
     * @return
     */
    @GetMapping("relate")
    public Msg relate(@RequestParam String basicId,
                      @RequestParam String userId) {
        if (basicId != null && userId != null){
            int flag = iDtAcctServiceImpl.relate(Integer.parseInt(basicId),Integer.parseInt(userId));
            if(flag == -1){
                return Msg.fail().add("msg","已经关联!");

            }else{
                return Msg.success().add("msg","关联成功！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 取消关联 经销商账号和经销商
     * @param basicId
     * @param userId
     * @return
     */
    @GetMapping("remove")
    public Msg remove(@RequestParam String basicId,
                      @RequestParam String userId){
        if (basicId != null && userId != null){
            int flag = iDtAcctServiceImpl.remove(Integer.parseInt(basicId),Integer.parseInt(userId));
            if(flag == 1){
                return Msg.success().add("msg","解除关联成功！");
            }else{
                return Msg.fail().add("msg","解除关联失败!");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 查询已关联的经销商
     * @param userId
     * @return
     */
    @GetMapping("relatedList")
    public Msg relatedList(@RequestParam Integer userId){
        if (userId != 0){
            List<Basic> basicList = iDtAcctServiceImpl.relatedList(userId);
            if (basicList != null && basicList.size() > 0){
                return Msg.success().add("msg", "查询成功！")
                                    .add("data", basicList);
            }else{
                return Msg.fail().add("msg", "未查询到任何信息！");
            }
        }else{
            return Msg.fail().add("msg","参数错误！");
        }
    }
}
