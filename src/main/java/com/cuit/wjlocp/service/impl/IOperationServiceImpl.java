package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.Actor;
import com.cuit.wjlocp.entity.Org;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.IOperationDao;
import com.cuit.wjlocp.service.IOperationService;
import com.cuit.wjlocp.vo.UserWithName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author X to Y
 * @date 2020/12/25-20:33
 */
@Service
public class IOperationServiceImpl implements IOperationService {

    @Autowired
    private IOperationDao iOperationDao;

    @Override
    public Page<UserWithName> selectAllOpertaion() {
        return iOperationDao.selectAllOperation();
    }

    @Override
    public Page<Actor>  selectAllActor() {
        return iOperationDao.selectAllActor();
    }

    @Override
    public List<Org> selectAllOrg() {
        return iOperationDao.selectAllOrg();
    }

    @Override
    public int enableOperation(Integer id) {
       return iOperationDao.enableOperation(id);
    }

    @Override
    public int disableOperation(Integer id) {
        return iOperationDao.disableOperation(id);
    }
    
    @Override
    public int deleteAccount(Integer id){
        return iOperationDao.deleteAccount(id);
    }

    @Override
    public int addActor(Actor actor) {
        return iOperationDao.addActor(actor);
    }

    @Override
    public int deleteActor(Integer id) {
        return iOperationDao.deleteActor(id);
    }

    @Override
    public int enableActor(Integer id) {
        return iOperationDao.enableActor(id);
    }

    @Override
    public int disableActor(Integer id) {
        return iOperationDao.disableActor(id);
    }

    @Override
    public Page<Actor> findActors(Actor actor) {
        return iOperationDao.findActors(actor);
    }

    @Override
    public Page<UserWithName> findOperations(UserWithName userWithName) {
        return iOperationDao.findOperations(userWithName);
    }

    @Override
    public int addAccount(User user) {
        return iOperationDao.addAccount(user);
    }

    @Override
    public int changeAccount(User user) {
        return iOperationDao.changeAccount(user);
    }

    @Override
    public int resetPassword(Integer id) {
        return iOperationDao.resetPassword(id);
    }

    @Override
    public int changeActorInfo(Actor actor) {
        return iOperationDao.changeActorInfo(actor);
    }
}
