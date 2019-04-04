package com.github.lotusmeanseight;

import com.github.lotusmeanseight.entity.config.DatasourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = DatasourceConfig.class)
public class SpringBootApp {

    public static void main(String[] args){
        SpringApplication.run(SpringBootApp.class, args);
    }

}
