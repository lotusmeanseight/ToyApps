package com.github.lotusmeanseight.entity.service.impl;

import com.github.lotusmeanseight.entity.Customer;
import com.github.lotusmeanseight.entity.service.DefaultService;

public class CustomerService extends DefaultService<Customer> {

    public CustomerService(){
    }

    @Override
    public void save(Customer entity) {
        super.save(entity);
    }

    @Override
    public Customer find(Customer entity) {
        return super.find(entity);
    }

    @Override
    public void update(Customer entity) {
        super.update(entity);
    }

    @Override
    public void delete(Customer entity) {
        super.delete(entity);
    }

}
