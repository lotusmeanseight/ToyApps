package com.github.lotusmeanseight.testentity;

import com.github.lotusmeanseight.entity.Customer;
import com.github.lotusmeanseight.entity.Reservation;
import com.github.lotusmeanseight.entity.Table;
import com.github.lotusmeanseight.entity.repository.CustomerRepository;
import com.github.lotusmeanseight.entity.repository.ReserverationRepository;
import com.github.lotusmeanseight.entity.repository.TableRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ReservationTest {

    @Autowired
    private ReserverationRepository reserverationRepository;
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
        reserverationRepository.save(reservation);
        Assertions.assertEquals(reserverationRepository.
                findByCustomerAndTableList(customer, reservation.getTableList()).getCustomer(), customer);
        Assertions.assertEquals(reserverationRepository.
                findByCustomerAndTableList(customer, reservation.getTableList()).getTableList().get(0), table);
    }

}
