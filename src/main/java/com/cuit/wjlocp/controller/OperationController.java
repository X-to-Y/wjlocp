package com.cuit.wjlocp.controller;

import com.cuit.wjlocp.entity.Actor;
import com.cuit.wjlocp.entity.Org;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.service.impl.IOperationServiceImpl;
import com.cuit.wjlocp.utils.Msg;
import com.cuit.wjlocp.vo.UserWithName;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/25-20:21
 *
 * 运营账号管理类
 * 控制层
 */


@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private IOperationServiceImpl iOperationService;

    /***
     * 1 -  99999不选择分页查询
     *  查询所有运营账号信息；
     * @param pageParam 请求页号
     * @param limitParam 页面条数
     * @return
     */
    @GetMapping("allAccount")
    public Msg selectAllOperation(@RequestParam String pageParam,
                                  @RequestParam String limitParam){
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<UserWithName> usersList = iOperationService.selectAllOpertaion();
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
            Page<UserWithName> usersList = iOperationService.selectAllOpertaion();
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",usersList)
                    .add("page",pageParam)
                    .add("totalPage",(usersList.getTotal()/(Integer.parseInt(limitParam)))+1);
        }
    }

    /***
     * 查询所有运营角色
     * @param pageParam
     * @param limitParam
     * @return
     */
    @GetMapping("allActor")
    public Msg selectAllActor(@RequestParam String pageParam,
                              @RequestParam String limitParam){
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<Actor> actorsList = iOperationService.selectAllActor();
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",actorsList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<Actor> actorsList = iOperationService.selectAllActor();
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",actorsList)
                    .add("page",pageParam)
                    .add("totalPage",(actorsList.getTotal()/(Integer.parseInt(limitParam)))+1);

        }
    }

    /***
     * 查询所属机构 下拉菜单
     * @return
     */
    @GetMapping("allOrg")
    public Msg selectAllOrg(){
        List<Org> orgs = iOperationService.selectAllOrg();
        if (orgs.size() > 0){
            return Msg.success().add("data", orgs).add("msg","查询成功！");
        }else{
            return Msg.fail().add("msg","未查询到任何机构！");
        }
    }

    /***
     * 启用运营账号
     * @param id
     * @return
     */
    @GetMapping("enableOperation")
    public Msg enableOperation(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.enableOperation(id);
            if(1 == flag){
                return Msg.success().add("msg", "启用成功！");
            }else{
                return Msg.fail().add("msg", "启用失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 禁用运营账号
     * @param id
     * @return
     */
    @GetMapping("disableOperation")
    public Msg disableOperation(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.disableOperation(id);
            if(1 == flag){
                return Msg.success().add("msg", "禁用成功！");
            }else{
                return Msg.fail().add("msg", "禁用失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 删除运营账号
     * @param id
     * @return
     */
    @GetMapping("deleteAccount")
    public Msg deleteOperation(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.deleteAccount(id);
            if(1 == flag){
                return Msg.success().add("msg", "删除成功！");
            }else{
                return Msg.fail().add("msg", "删除失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 新增运营角色
     * @param actor
     * @return
     */
    @PostMapping("addActor")
    public Msg addActor(@RequestBody Actor actor){
        if ( actor != null ){
            int flag = iOperationService.addActor(actor);
            if(1 == flag){
                return Msg.success().add("msg", "新增成功！");
            }else{
                return Msg.fail().add("msg", "新增失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 删除运营角色
     * @param id
     * @return
     */
    @GetMapping("deleteActor")
    public Msg deleteActor(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.deleteActor(id);
            if(1 == flag){
                return Msg.success().add("msg", "删除成功！");
            }else{
                return Msg.fail().add("msg", "删除失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 启用运营角色
     * @param id
     * @return
     */
    @GetMapping("enableActor")
    public Msg enableActor(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.enableActor(id);
            if(1 == flag){
                return Msg.success().add("msg", "启用成功！");
            }else{
                return Msg.fail().add("msg", "启用失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 禁用运营角色
     * @param id
     * @return
     */
    @GetMapping("disableActor")
    public Msg disableActor(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.disableActor(id);
            if(1 == flag){
                return Msg.success().add("msg", "禁用成功！");
            }else{
                return Msg.fail().add("msg", "禁用失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 多条件查询运营角色
     * @param actor
     * @return
     */
    @PostMapping("findActors")
    public Msg findActors(@RequestBody Actor actor,
                          HttpServletRequest request){
        String pageParam = request.getHeader("pageParam");
        String limitParam = request.getHeader("limitParam");
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<Actor> actorsList = iOperationService.findActors(actor);
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",actorsList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<Actor> actorsList = iOperationService.findActors(actor);
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",actorsList)
                    .add("page",pageParam)
                    .add("totalPage",(actorsList.getTotal()/(Integer.parseInt(limitParam)))+1);
        }
    }

    /***
     * 多条件查询运营账号
     * @param userWithName
     * @return
     */
    @PostMapping("findOperations")
    public Msg findOperations(@RequestBody UserWithName userWithName,
                              HttpServletRequest request){
        String pageParam = request.getHeader("pageParam");
        String limitParam = request.getHeader("limitParam");
        if ( pageParam.equals("1") && limitParam.equals("99999")){
            List<UserWithName> uwnList = iOperationService.findOperations(userWithName);
            return Msg.success()
                    .add("msg","查询成功")
                    .add("data",uwnList);
        }
        else{
            //当前页数
            int page = !pageParam.equals("") ? Integer.parseInt(pageParam) : 1;
            //每页条数
            int limit = !limitParam.equals("") ? Integer.parseInt(limitParam) : 10;
            //分页
            PageHelper.startPage(page, limit);
            Page<UserWithName> awnList = iOperationService.findOperations(userWithName);
            return Msg.success()
                    .add("msg",  "查询成功！")
                    .add("data",awnList)
                    .add("page",pageParam)
                    .add("totalPage",(awnList.getTotal()/(Integer.parseInt(limitParam)))+1);
        }
    }

    /***
     * 新增运营账号
     * @param user
     * @return
     */
    @PostMapping("addAccount")
    public Msg addAccount(@RequestBody User user){
        if ( user != null ){
            int flag = iOperationService.addAccount(user);
            if(1 == flag){
                return Msg.success().add("msg", "新增成功！");
            }else{
                return Msg.fail().add("msg", "新增失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 修改运营账号信息
     * @param user
     * @return
     */
    @PostMapping("changeAccount")
    public Msg changeAccount(@RequestBody User user){
        if ( user != null ){
            int flag = iOperationService.changeAccount(user);
            if(1 == flag){
                return Msg.success().add("msg", "修改成功！");
            }else{
                return Msg.fail().add("msg", "修改失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 重置密码
     * @param id
     * @return
     */
    @GetMapping("resetPassword")
    public Msg resetPassword(@RequestParam Integer id){
        if ( id != 0 ){
            int flag = iOperationService.resetPassword(id);
            if(1 == flag){
                return Msg.success().add("msg", "重置成功！");
            }else{
                return Msg.fail().add("msg", "重置失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }

    /***
     * 修改角色信息
     * @param actor
     * @return
     */
    @PostMapping("changeActor")
    public Msg changeActorInfo(@RequestBody Actor actor){
        if ( actor != null ){
            int flag = iOperationService.changeActorInfo(actor);
            if(1 == flag){
                return Msg.success().add("msg", "修改角色成功！");
            }else{
                return Msg.fail().add("msg", "修改角色失败！");
            }
        }else{
            return Msg.fail().add("msg","参数有误！");
        }
    }
}
