package com.example.demo.service;

import com.example.common.bd.BDProduct;
import com.example.jpademo2.dao.qualifier.Demo2Database;
import com.example.demo.helper.EntityHelper;
import com.example.jpademo2.dao.impl.ProductEntityDao;
import com.example.jpademo2.repositories.ProductRepository;
import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Random;

@ApplicationScoped
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Inject
    private ProductEntityDao productEntityDao;

    @Inject
    private ProductRepository productRepository;

    @Transactional(qualifier = Demo2Database.class)
    public void addProduct(BDProduct bdProduct) {
        Random random = new Random();
        if (random.nextBoolean()) {
            productEntityDao.save(EntityHelper.bdToEntity(bdProduct));
        } else {
            productRepository.save(EntityHelper.bdToEntity(bdProduct));
        }
        List<BDProduct> products;
        if (random.nextBoolean()) {
            products = EntityHelper.entityToBdProducts(productEntityDao.findAll());
        } else {
            products = EntityHelper.entityToBdProducts(productRepository.findAll());
        }
        logger.info(products.toString());
    }

    @Transactional(qualifier = Demo2Database.class)
    public List<BDProduct> getAllProducts() {
        return EntityHelper.entityToBdProducts(productEntityDao.findAll());
    }

}
