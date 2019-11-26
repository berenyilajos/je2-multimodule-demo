package com.example.jpademo.dao.interfaces;

import java.util.List;
import java.util.function.Consumer;

public interface EntityDao<T> {

    T find(long id);

    List<T> findAll();

    void update(long id, Consumer<T>... updates) throws Exception;

    void save(T entity);

    void remove(long id);

}
