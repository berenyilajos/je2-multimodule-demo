package com.example.demo.service;

import com.example.demo.bd.BDProduct;
import com.example.demo.bd.BDUser;
import com.example.jpademo.dao.UserDao;
import com.example.demo.helper.EntityHelper;
//import com.example.jpademo.transactions.Transactional;
import com.example.jpademo.dao.impl.ProductEntityDao;
import com.example.jpademo.dao.impl.UserEntityDao;
import com.example.jpademo.dao.interfaces.EntityDao;
import com.example.jpademo.dao.repositories.UserRepositoryDao;
import com.example.jpademo.entity.Product;
import com.example.jpademo.entity.User;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
//import javax.transaction.Transactional;
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
    private ProductEntityDao productEntityDao;

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

    @Transactional
    public List<BDUser> getUserByName(String name) {
        return EntityHelper.entityToBd(userDao.findByName(name));
    }

    @Transactional
    public void addProduct(BDProduct bdProduct) {
        productEntityDao.save(EntityHelper.bdToEntity(bdProduct));
    }

    @Transactional
    public List<BDProduct> getAllProducts() {
        return EntityHelper.entityToBdProducts(productEntityDao.findAll());
    }
}
