package com.example.jpademo2.dao.repositories;

import com.example.jpademo2.entity.Product;
import com.example.jpademo2.transactions.Demo2EntityManagerResolver;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.Repository;

import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository(forEntity = Product.class)
@EntityManagerConfig(entityManagerResolver = Demo2EntityManagerResolver.class)
public abstract class ProductRepositoryDao extends AbstractEntityRepository<Product, Long> {

	public List<Product> getProductsCheaperThen(BigDecimal price) {
		String queryText = "SELECT p FROM Product p where p.price < :price";
//		TypedQuery<Product> query = entityManager().createQuery(queryText, Product.class);
		TypedQuery<Product> query = typedQuery(queryText);
		query.setParameter("price", price);

		return query.getResultList();
	}

	public abstract List<Product> findByName(String name);

}
