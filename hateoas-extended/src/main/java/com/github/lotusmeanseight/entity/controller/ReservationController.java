package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.repository.ReservationRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository repository){
        this.reservationRepository = repository;
    }

}
