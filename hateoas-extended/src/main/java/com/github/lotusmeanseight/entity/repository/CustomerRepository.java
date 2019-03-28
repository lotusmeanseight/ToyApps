package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    Customer findByEmail(String email);
    List<Customer> findByPhone(String phone);

}
