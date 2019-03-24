package com.github.lotusmeanseight.entity.service;

public interface GenericService<T, I> {

    void save(T entity);

    T find(T entity);

    T findById(I id);

    void update(T entity);

    void updateById(I id);

    void delete(T entity);

    void deleteById(I id);

}
