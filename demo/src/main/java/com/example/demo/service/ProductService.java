package com.example.demo.service;

import com.example.common.bd.BDProduct;
import com.example.common.dao.db.Demo2Database;
import com.example.demo.helper.EntityHelper;
import com.example.jpademo2.dao.impl.ProductEntityDao;
import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductEntityDao productEntityDao;

    @Transactional(qualifier = Demo2Database.class)
    public void addProduct(BDProduct bdProduct) {
        productEntityDao.save(EntityHelper.bdToEntity(bdProduct));
    }

    @Transactional(qualifier = Demo2Database.class)
    public List<BDProduct> getAllProducts() {
        return EntityHelper.entityToBdProducts(productEntityDao.findAll());
    }

}
