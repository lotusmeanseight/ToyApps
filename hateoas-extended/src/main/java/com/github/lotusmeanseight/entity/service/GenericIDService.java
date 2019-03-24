package com.github.lotusmeanseight.entity.service;

public interface GenericIDService<T, I> extends GenericService<T> {

    T findById(I id);

    void updateWithId(I id);

    void deleteWithId(I id);

}
