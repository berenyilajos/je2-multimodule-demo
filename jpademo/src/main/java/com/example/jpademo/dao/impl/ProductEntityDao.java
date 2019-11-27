package com.example.jpademo.dao.impl;

import com.example.jpademo.dao.base.BaseEntityDao;
import com.example.jpademo.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ProductEntityDao extends BaseEntityDao<Product> {

    @Inject
    public ProductEntityDao(EntityManager entityManager) {
        super(entityManager, Product.class);
    }
}

