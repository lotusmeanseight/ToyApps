package com.github.lotusmeanseight.entity.controller;

import com.github.lotusmeanseight.entity.Customer;
import com.github.lotusmeanseight.entity.repository.CustomerRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers/{id}")
    public EntityModel<Customer> findOne(@PathVariable Integer id){
        Class<CustomerController> controllerClass = CustomerController.class;
        var selfLink = linkTo(methodOn(controllerClass).findOne(id)).withSelfRel();
        var customer = customerRepository.findById(id).get();
        return new EntityModel<>(customer, selfLink);
    }

    @GetMapping("/customers")
    public ResponseEntity<CollectionModel<EntityModel<Customer>>> findAll(){
        return ResponseEntity.ok(CollectionModel.wrap(customerRepository.findAll()));
    }

}
