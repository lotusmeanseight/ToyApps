package com.github.lotusmeanseight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.github.lotusmeanseight.entity"})
public class SpringBootApp {

    public static void main(String[] args){
        SpringApplication.run(SpringBootApp.class, args);
    }

}
