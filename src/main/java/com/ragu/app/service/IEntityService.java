package com.ragu.app.service;

import java.util.List;

public interface IEntityService<T> {

	List<T> findAll();

	T save(T entity);
	
	T update(T entity);

	T findOne(int id);

	boolean delete(int id);

}
