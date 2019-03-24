package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
