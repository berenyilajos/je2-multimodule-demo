package com.example.demo.service;

import com.example.demo.bd.BDUser;
import com.example.jpademo.dao.UserDao;
import com.example.demo.helper.EntityHelper;
//import com.example.jpademo.transactions.Transactional;
import com.example.jpademo.dao.repositories.UserRepositoryDao;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
//import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private UserRepositoryDao userRepositoryDao;

    @Transactional
    public List<BDUser> getAllUsers(){
//        return EntityHelper.entityToBd(userDao.findAll());
        return EntityHelper.entityToBd(userRepositoryDao.getAll());
    }

    @Transactional
    public BDUser getUser(long id){
        return EntityHelper.entityToBd(userDao.findOneById(id));
    }

    @Transactional
    public void addUser(BDUser bdUser){
        userRepositoryDao.save(EntityHelper.bdToEntity(bdUser));
        System.err.println(EntityHelper.entityToBd(userDao.findAll()));
        System.err.println(EntityHelper.entityToBd(userRepositoryDao.getAll()));
        System.err.println(EntityHelper.entityToBd(userRepositoryDao.getAll()));
        System.err.println(EntityHelper.entityToBd(userDao.findByName(bdUser.getName())));

    }

    @Transactional
    public List<BDUser> getUserByName(String name) {
        return EntityHelper.entityToBd(userDao.findByName(name));
    }
}
