package com.example.common.dao.base;

import com.example.common.dao.interfaces.EntityDao;

import javax.persistence.EntityManager;
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

    public void update(T entity, Consumer<T> update) throws Exception {
        update.accept(entity);
    }

    public T save(T entity) {
        return entityManager.merge(entity);
    }

    public void remove(long id) {
        T entity = find(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

}
