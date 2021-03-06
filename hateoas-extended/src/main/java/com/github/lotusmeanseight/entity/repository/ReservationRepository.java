package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Customer;
import com.github.lotusmeanseight.entity.Reservation;
import com.github.lotusmeanseight.entity.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    Reservation findByCustomerAndTableList(Customer customer, List<Table> tableList);
    Reservation findByTitleAndAndCustomer(String title, Customer customer);
    List<Reservation> findByCustomer(Customer customer);

}
