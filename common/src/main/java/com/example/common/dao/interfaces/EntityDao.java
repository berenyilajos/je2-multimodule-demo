package com.example.common.dao.interfaces;

import java.util.List;
import java.util.function.Consumer;

public interface EntityDao<T> {

    T find(long id);

    List<T> findAll();

    void update(T entity, Consumer<T> update) throws Exception;

    T save(T entity);

    void remove(long id);

}
