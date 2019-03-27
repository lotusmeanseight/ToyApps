package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.Wine;
import com.github.lotusmeanseight.entity.repository.WineRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class WineController {

    private final WineRepository wineRepository;

    public WineController(WineRepository wineRepository){
        this.wineRepository = wineRepository;
    }

    @GetMapping("/wines/{id}")
    public EntityModel<Wine> findOne(@PathVariable Integer id){
        Class<WineController> controllerClass = WineController.class;
        var selfLink = linkTo(methodOn(controllerClass).findOne(id)).withSelfRel();
        var wine = wineRepository.findById(id).get();
        return new EntityModel<>(wine, selfLink);
    }

    @GetMapping("/wines")
    public ResponseEntity<CollectionModel<EntityModel<Wine>>> findAll(){
        return ResponseEntity.ok(CollectionModel.wrap(wineRepository.findAll()));
    }

}
