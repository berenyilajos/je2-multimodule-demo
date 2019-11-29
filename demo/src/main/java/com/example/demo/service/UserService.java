package com.example.demo.service;

import com.example.common.bd.BDUser;
import com.example.jpademo.dao.qualifier.DemoDatabase;
import com.example.jpademo.dao.UserDao;
import com.example.demo.helper.EntityHelper;
import com.example.jpademo.dao.impl.UserEntityDao;
import com.example.jpademo.dao.repositories.UserRepositoryDao;
import com.example.jpademo.entity.User;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@ApplicationScoped
public class UserService {

    @Inject
    private UserDao userDao;

    @Inject
    private UserEntityDao userEntityDao;

    @Inject
    private UserRepositoryDao userRepositoryDao;

    @Transactional(qualifier = DemoDatabase.class)
    public List<BDUser> getAllUsers(){
        return EntityHelper.entityToBd(userDao.findAll());
//        return EntityHelper.entityToBd(userRepositoryDao.getAll());
    }

    @Transactional(qualifier = DemoDatabase.class)
    public BDUser getUser(long id){
        return EntityHelper.entityToBd(userDao.findOneById(id));
    }

    @Transactional(qualifier = DemoDatabase.class)
    public void addUser(BDUser bdUser){
        User user;
        if (new Random().nextBoolean()) {
            user = userRepositoryDao.save(EntityHelper.bdToEntity(bdUser));
        } else {
            user = userEntityDao.save(EntityHelper.bdToEntity(bdUser));
        }
        try {
            Consumer<User> cons = u -> {
                String[] email = user.getEmail().split("@");
                u.setName(email[0]);
                u.setEmail(email[0] + "0" + "@" + email[1]);
            };
            userEntityDao.update(user, cons);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println(EntityHelper.entityToBd(userDao.findAll()));
        System.err.println(EntityHelper.entityToBd(userEntityDao.findAll()));
        System.err.println(EntityHelper.entityToBd(userRepositoryDao.getAll()));
        System.err.println(EntityHelper.entityToBd(userRepositoryDao.getAll()));
        System.err.println(EntityHelper.entityToBd(userDao.findByName(bdUser.getName())));

    }

    @Transactional(qualifier = DemoDatabase.class)
    public List<BDUser> getUsersByName(String name) {
//        return EntityHelper.entityToBd(userDao.findByName(name));
        return EntityHelper.entityToBd(userEntityDao.getUsersByName(name));
    }

}
