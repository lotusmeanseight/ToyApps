package com.github.lotusmeanseight.entity;

import com.github.lotusmeanseight.entity.repository.CustomerRepository;
import com.github.lotusmeanseight.entity.repository.ReservationRepository;
import com.github.lotusmeanseight.entity.repository.TableRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReservationTest {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void reservationExists(){
        Customer customer = new Customer("Max", "Mustermann", "0000 0000 0000",
                "max@mustermann.de");
        Table table = new Table();
        Reservation reservation = new Reservation(customer,"Bank of scotland", "eats only vegan");
        reservation.getTableList().add(table);
        tableRepository.save(table);
        customerRepository.save(customer);
        reservationRepository.save(reservation);
        Assertions.assertEquals(reservationRepository.
                findByCustomerAndTableList(customer, reservation.getTableList()).getCustomer(), customer);
        Assertions.assertEquals(reservationRepository.
                findByCustomerAndTableList(customer, reservation.getTableList()).getTableList().get(0), table);
    }

}
