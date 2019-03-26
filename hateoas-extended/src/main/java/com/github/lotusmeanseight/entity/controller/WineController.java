package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WineController {

    private final WineRepository wineRepository;

    @Autowired
    public WineController(WineRepository wineRepository){
        this.wineRepository = wineRepository;
    }



}
