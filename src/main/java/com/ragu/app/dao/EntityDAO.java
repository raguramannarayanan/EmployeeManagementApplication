package com.ragu.app.dao;

import java.util.List;

public interface EntityDAO<T> {

    List <T> findAll();

    T save(T entity);
    
    T update(T entity);

    T findOne(int id);

    boolean delete(int id);
}
