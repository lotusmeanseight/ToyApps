package com.github.lotusmeanseight.entity.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DefaultService<T> implements GenericService<T> {

    @Autowired
    private EntityManager entityManager;
    private Class<T> tClass;
    private T type;

    public DefaultService(){
        this.tClass = (Class<T>) type.getClass();
    }

    @Override
    public void save(T entity) {
        this.entityManager.persist(entity);
    }

    @Override
    public T find(T entity) {
        return entityManager.find(tClass, entity);
    }


    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }

}
