package com.example.common.dao.interfaces;

import com.example.common.entity.Entity;

import java.util.List;
import java.util.function.Consumer;

public interface EntityDao<T extends Entity> {

    T find(long id);

    List<T> findAll();

    void update(T entity, Consumer<T> update) throws Exception;

    T save(T entity);

    void remove(long id);

}
