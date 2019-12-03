package com.example.common.dao.interfaces;

import com.example.common.entity.Entity;

import java.util.List;
import java.util.function.Consumer;

public interface EntityDao<T, ID> {

    T find(ID id);

    List<T> findAll();

    void update(T entity, Consumer<T> update) throws Exception;

    T save(T entity);

    void removeById(ID id);

    void remove(T entity);

}
