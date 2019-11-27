package com.example.jpademo.dao.repositories;

import com.example.jpademo.entity.User;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository(forEntity = User.class)
public abstract class UserRepositoryDao implements EntityRepository<User, Long> {

    @Inject
    private EntityManager em;

    public List<User> getAll() {
        String queryText = "SELECT u from User u";
        TypedQuery<User> query = em.createQuery(queryText, User.class);
        return query.getResultList();
    }

    public abstract List<User> findByName(String name);
    public abstract User findOneById(long id);
}