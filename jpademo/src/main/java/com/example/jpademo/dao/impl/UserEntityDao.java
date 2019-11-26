package com.example.jpademo.dao.impl;

import com.example.jpademo.dao.base.BaseEntityDao;
import com.example.jpademo.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class UserEntityDao extends BaseEntityDao<User> {

    @Inject
    public UserEntityDao(EntityManager entityManager) {
        super(entityManager, User.class);
    }
}
