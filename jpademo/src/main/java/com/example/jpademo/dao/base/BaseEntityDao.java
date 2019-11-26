package com.example.jpademo.dao.base;

import com.example.jpademo.dao.interfaces.EntityDao;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class BaseEntityDao<T> implements EntityDao<T> {

    private EntityManager entityManager;
    private Class<T> entityClass;

    public BaseEntityDao(
            EntityManager entityManager,
            Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public T find(long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        String jpql = "select e from " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(jpql, entityClass).getResultList();
    }

    public void update(long id, Consumer<T>... updates) throws Exception {
        T entity = find(id);
        Arrays.stream(updates).forEach(up -> up.accept(entity));
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void remove(long id) {
        T entity = find(id);
        entityManager.remove(entity);
    }

}
