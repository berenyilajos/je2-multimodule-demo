package com.example.jpademo2.repositories;

import com.example.jpademo2.entity.Product;
import com.example.jpademo2.transactions.Demo2EntityManagerResolver;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.jpa.api.entitymanager.EntityManagerConfig;

@Repository(forEntity = Product.class)
@EntityManagerConfig(entityManagerResolver = Demo2EntityManagerResolver.class)
public interface ProductRepository extends EntityRepository<Product, Long> {
}
