package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.repository.TableRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {

    private final TableRepository tableRepository;

    public TableController(TableRepository repository){
        this.tableRepository = repository;
    }

}
