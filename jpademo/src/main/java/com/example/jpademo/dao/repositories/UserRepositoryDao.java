package com.example.jpademo.dao.repositories;

import com.example.common.dao.db.DemoDatabase;
import com.example.jpademo.entity.User;
import com.example.jpademo.transactions.DemoEntityManagrResolver;
import org.apache.deltaspike.data.api.EntityManagerConfig;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository(forEntity = User.class)
@EntityManagerConfig(entityManagerResolver = DemoEntityManagrResolver.class)
public abstract class UserRepositoryDao implements EntityRepository<User, Long> {

    @Inject
    @DemoDatabase
    private EntityManager em;

    public List<User> getAll() {
        String queryText = "SELECT u from User u";
        TypedQuery<User> query = em.createQuery(queryText, User.class);
        return query.getResultList();
    }

    public abstract List<User> findByName(String name);
    public abstract User findOneById(long id);
}
