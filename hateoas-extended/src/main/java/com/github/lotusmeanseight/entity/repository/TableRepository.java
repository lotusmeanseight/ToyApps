package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Reservation;
import com.github.lotusmeanseight.entity.Table;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TableRepository extends CrudRepository<Table, Integer> {
    Table findByReservation(Reservation reservation);
    List<Table> findByDeluxe(boolean deluxe);
}
