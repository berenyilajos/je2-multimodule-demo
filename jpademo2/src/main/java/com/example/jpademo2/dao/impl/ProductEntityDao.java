package com.example.jpademo2.dao.impl;

import com.example.common.dao.base.BaseEntityDao;
import com.example.jpademo2.dao.qualifier.Demo2Database;
import com.example.jpademo2.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ProductEntityDao extends BaseEntityDao<Product, Long> {

    @Inject
    public ProductEntityDao(@Demo2Database EntityManager entityManager) {
        super(entityManager, Product.class);
    }
}

