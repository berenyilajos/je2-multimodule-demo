package com.example.jpademo.dao.impl;

import com.example.common.dao.base.BaseEntityDao;
import com.example.jpademo.dao.qualifier.DemoDatabase;
import com.example.jpademo.entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class UserEntityDao extends BaseEntityDao<User, Long> {

    @Inject
    public UserEntityDao(@DemoDatabase EntityManager entityManager) {
        super(entityManager, User.class);
    }

    public List<User> getUsersByName(String name) {
        String queryText = "SELECT u FROM User u WHERE u.name = :name";
//        TypedQuery<User> query = getEntityManager().createQuery(queryText, User.class);
        TypedQuery<User> query = typedQuery(queryText);
        query.setParameter("name", name);

        return query.getResultList();
    }
}
