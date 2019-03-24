package com.github.lotusmeanseight.entity.service.impl;

import com.github.lotusmeanseight.entity.Dish;
import com.github.lotusmeanseight.entity.service.DefaultService;
import com.github.lotusmeanseight.entity.service.GenericService;

public class DishService extends DefaultService<Dish> {

    public DishService(){
    }

    @Override
    public void save(Dish entity) {
        super.save(entity);
    }

    @Override
    public Dish find(Dish entity) {
        return super.find(entity);
    }

    @Override
    public void update(Dish entity) {
        super.update(entity);
    }

    @Override
    public void delete(Dish entity) {
        super.delete(entity);
    }
}
