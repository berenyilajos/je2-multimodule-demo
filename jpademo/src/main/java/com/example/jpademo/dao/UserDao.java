package com.example.jpademo.dao;

import com.example.common.dao.db.DemoDatabase;
//import com.example.jpademo.dao.repositories.UserRepository;
import com.example.jpademo.entity.User;
import com.example.jpademo.repositories.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class UserDao {

    @Inject
    @DemoDatabase
    private EntityManager em;

    @Inject
    private UserRepository userRepository;

    public List<User> findAll() {
//        String queryText = "SELECT u from User u";
//        TypedQuery<User> query = em.createQuery(queryText, User.class);
//        return query.getResultList();
        return userRepository.findAll();
    }

    public User findOneById(long id) {
        String queryText = "SELECT u from User u where id = :id";
        TypedQuery<User> query = em.createQuery(queryText, User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
//        return userRepository.findOneById(id);
    }

    public List<User> findByName(String name) {
        String queryText = "SELECT u from User u where u.name = :name";
        TypedQuery<User> query = em.createQuery(queryText, User.class);
        query.setParameter("name", name);
        return query.getResultList();
//        return userRepository.findByName(name);
    }

    public void save(User user) {
        System.out.println("Saving user : " + user);
        em.persist(user);
//        userRepository.save(user);
    }
}
