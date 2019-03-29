package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.Wine;
import com.github.lotusmeanseight.entity.repository.WineRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class WineController {

    private final WineRepository wineRepository;
    private Class<WineController> controllerClass;

    public WineController(WineRepository wineRepository){
        this.wineRepository = wineRepository;
        this.controllerClass = WineController.class;
    }

    @GetMapping("/wines/{id}")
    public ResponseEntity<EntityModel<Wine>> findOne(@PathVariable Integer id){
        return wineRepository.findById(id)
                .map(wine -> new EntityModel<>(wine,linkTo(methodOn(controllerClass).findOne(id)).withSelfRel()
                        .andAffordance(afford(linkTo(methodOn(controllerClass).findAll())))))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/wines")
    public ResponseEntity<CollectionModel<EntityModel<Wine>>> findAll(){
        List<EntityModel<Wine>> wines = StreamSupport.stream(wineRepository.findAll().spliterator(), false)
                .map(wine -> new EntityModel<>(wine, linkTo(methodOn(controllerClass).findOne(wine.getId()))
                        .withSelfRel().andAffordance(afford(linkTo(methodOn(controllerClass).createWine(null))))))
                .collect(Collectors.toList());
        return ResponseEntity.ok(new CollectionModel<>(wines));
    }

    @PostMapping("/wines")
    public ResponseEntity<Wine> createWine(@RequestBody Wine newWine){
        //TODO
        Wine wine = wineRepository.save(newWine);
        return null;
    }

}
