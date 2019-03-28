package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.repository.MenuRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository repository){
        this.menuRepository = repository;
    }

}
