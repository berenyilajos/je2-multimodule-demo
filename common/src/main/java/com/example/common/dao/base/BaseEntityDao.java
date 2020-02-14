package com.example.common.dao.base;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.function.Consumer;

public abstract class BaseEntityDao<E, ID> {

    private EntityManager entityManager;
    private Class<E> entityClass;

    public BaseEntityDao(
            EntityManager entityManager,
            Class<E> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public E find(ID id) {
        return entityManager.find(entityClass, id);
    }

    public List<E> findAll() {
        String jpql = "select e from " + entityClass.getSimpleName() + " e";
        return typedQuery(jpql).getResultList();
    }

    public void update(E entity, Consumer<E> update) throws Exception {
        update.accept(entity);
    }

    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void removeById(ID id) {
        E entity = find(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void remove(E entity) {
        entityManager.remove(entity);
    }

    protected TypedQuery<E> typedQuery(String jpql) {
        return entityManager.createQuery(jpql, entityClass);
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

}
