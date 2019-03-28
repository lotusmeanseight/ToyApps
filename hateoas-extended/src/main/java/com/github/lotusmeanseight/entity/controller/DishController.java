package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.Dish;
import com.github.lotusmeanseight.entity.repository.DishRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class DishController {

    private final DishRepository dishRepository;

    public DishController(DishRepository repository){
        this.dishRepository = repository;
    }

    @GetMapping("/dishes/{id}")
    public EntityModel<Dish> findOne(@PathVariable Integer id){
        Class<DishController> controllerClass = DishController.class;
        var selfLink = linkTo(methodOn(controllerClass).findOne(id)).withSelfRel();
        var dish = dishRepository.findById(id).get();
        return new EntityModel<>(dish, selfLink);
    }

    @GetMapping("/dishes")
    public ResponseEntity<CollectionModel<EntityModel<Dish>>> findAll(){
        return ResponseEntity.ok(CollectionModel.wrap(dishRepository.findAll()));
    }
}
