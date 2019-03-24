package com.github.lotusmeanseight.entity.service;

public interface GenericService<T> {

    void save(T entity);

    T find(T entity);

    void update(T entity);

    void delete(T entity);


}
