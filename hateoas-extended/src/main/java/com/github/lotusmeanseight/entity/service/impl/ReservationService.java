package com.github.lotusmeanseight.entity.service.impl;

import com.github.lotusmeanseight.entity.Reservation;
import com.github.lotusmeanseight.entity.service.DefaultService;
import com.github.lotusmeanseight.entity.service.GenericService;

public class ReservationService extends DefaultService<Reservation> {

    public ReservationService(){
    }

    @Override
    public void save(Reservation entity) {
        super.save(entity);
    }

    @Override
    public Reservation find(Reservation entity) {
        return super.find(entity);
    }

    @Override
    public void update(Reservation entity) {
        super.update(entity);
    }

    @Override
    public void delete(Reservation entity) {
        super.delete(entity);
    }
}
