package com.example.jpademo.dao.repositories;

import com.example.jpademo.entity.User;
import com.example.jpademo.transactions.DemoEntityManagerResolver;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository(forEntity = User.class)
@EntityManagerConfig(entityManagerResolver = DemoEntityManagerResolver.class)
public abstract class UserRepositoryDao extends AbstractEntityRepository<User, Long> {

    public List<User> getAll() {
        String queryText = "SELECT u from User u";
//        TypedQuery<User> query = entityManager().createQuery(queryText, User.class);
        TypedQuery<User> query = typedQuery(queryText);
        return query.getResultList();
    }

    public abstract List<User> findByName(String name);
    public abstract User findOneById(long id);
}
