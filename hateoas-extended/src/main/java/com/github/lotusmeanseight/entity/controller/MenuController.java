package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.Menu;
import com.github.lotusmeanseight.entity.repository.MenuRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MenuController {

    private final MenuRepository menuRepository;

    public MenuController(MenuRepository repository){
        this.menuRepository = repository;
    }

    @GetMapping("/menus/{id}")
    public EntityModel<Menu> findOne(@PathVariable Integer id){
        Class<MenuController> controllerClass = MenuController.class;
        var selfLink = linkTo(methodOn(controllerClass).findOne(id)).withSelfRel();
        var menus = menuRepository.findById(id).get();
        return new EntityModel<>(menus, selfLink);
    }

    @GetMapping("/menus/")
    public ResponseEntity<CollectionModel<EntityModel<Menu>>> findAll(){
        return ResponseEntity.ok(CollectionModel.wrap(menuRepository.findAll()));
    }

}
