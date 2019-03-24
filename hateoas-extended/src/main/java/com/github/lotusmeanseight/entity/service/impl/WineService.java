package com.github.lotusmeanseight.entity.service.impl;

import com.github.lotusmeanseight.entity.Wine;
import com.github.lotusmeanseight.entity.service.DefaultService;

public class WineService extends DefaultService<Wine> {

    public WineService(){
    }

    @Override
    public void save(Wine entity) {
        super.save(entity);
    }

    @Override
    public Wine find(Wine entity) {
        return super.find(entity);
    }

    @Override
    public void update(Wine entity) {
        super.update(entity);
    }

    @Override
    public void delete(Wine entity) {
        super.delete(entity);
    }
}
