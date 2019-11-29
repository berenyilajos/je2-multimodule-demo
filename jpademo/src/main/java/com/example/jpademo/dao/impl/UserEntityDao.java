package com.example.jpademo.dao.impl;

import com.example.common.dao.base.BaseEntityDao;
import com.example.jpademo.dao.qualifier.DemoDatabase;
import com.example.jpademo.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class UserEntityDao extends BaseEntityDao<User> {

    @Inject
    public UserEntityDao(@DemoDatabase EntityManager entityManager) {
        super(entityManager, User.class);
    }
}
