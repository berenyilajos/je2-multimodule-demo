package com.example.demo.service;

import com.example.demo.bd.BDUser;
import com.example.jpademo.dao.UserDao;
import com.example.demo.helper.EntityHelper;
//import com.example.jpademo.transactions.Transactional;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
//import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserDao userDao;

    @Transactional
    public List<BDUser> getAllUsers(){
        return EntityHelper.entityToBd(userDao.findAll());
    }

    @Transactional
    public BDUser getUser(long id){
        return EntityHelper.entityToBd(userDao.findOneById(id));
    }

    @Transactional
    public void addUser(BDUser bdUser){
        userDao.save(EntityHelper.bdToEntity(bdUser));
    }

    @Transactional
    public List<BDUser> getUserByName(String name) {
        return EntityHelper.entityToBd(userDao.findByName(name));
    }
}
