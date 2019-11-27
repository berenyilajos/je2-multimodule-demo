package com.example.jpademo.dao.impl;

import com.example.jpademo.dao.base.BaseEntityDao;
import com.example.jpademo.entity.Product;
import com.example.jpademo.transactions.Demo2Database;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ProductEntityDao extends BaseEntityDao<Product> {

    @Inject
    @Demo2Database
    private EntityManager em;

    public ProductEntityDao() {
        super(null, Product.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

//    @Inject
//    public ProductEntityDao(@Demo2Database EntityManager entityManager) {
//        super(entityManager, Product.class);
//    }

//    @Inject
//    public void setEntityManager(@Demo2Database EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
}

