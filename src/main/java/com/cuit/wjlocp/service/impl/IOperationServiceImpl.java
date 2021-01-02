package com.cuit.wjlocp.service.impl;

import com.cuit.wjlocp.entity.Actor;
import com.cuit.wjlocp.entity.Org;
import com.cuit.wjlocp.entity.User;
import com.cuit.wjlocp.mapper.IOperationDao;
import com.cuit.wjlocp.service.IOperationService;
import com.cuit.wjlocp.vo.UserWithName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UserWithName> selectAllOpertaion() {
        return iOperationDao.selectAllOperation();
    }

    @Override
    public List<Actor> selectAllActor() {
        return iOperationDao.selectAllActor();
    }

    @Override
    public List<Org> selectAllOrg() {
        return iOperationDao.selectAllOrg();
    }

    @Override
    public int enableOperation(String userName) {
       return iOperationDao.enableOperation(userName);
    }

    @Override
    public int disableOperation(String userName) {
        return iOperationDao.disableOperation(userName);
    }
    
    @Override
    public int deleteAccount(String userName){
        return iOperationDao.deleteAccount(userName);
    }

    @Override
    public int addActor(Actor actor) {
        return iOperationDao.addActor(actor);
    }

    @Override
    public int deleteActor(String actorName) {
        return iOperationDao.deleteActor(actorName);
    }

    @Override
    public int enableActor(String actorName) {
        return iOperationDao.enableActor(actorName);
    }

    @Override
    public int disableActor(String actorName) {
        return iOperationDao.disableActor(actorName);
    }

    @Override
    public List<Actor> findActors(Actor actor) {
        return iOperationDao.findActors(actor);
    }

    @Override
    public List<UserWithName> findOperations(UserWithName userWithName) {
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
    public int resetPassword(String userName) {
        return iOperationDao.resetPassword(userName);
    }

    @Override
    public int changeActorInfo(Actor actor) {
        return iOperationDao.changeActorInfo(actor);
    }
}
