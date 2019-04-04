package com.github.lotusmeanseight;

import com.github.lotusmeanseight.entity.config.DatasourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = DatasourceConfig.class)
public class SpringBootApp {

    public static void main(String[] args){
        SpringApplication.run(SpringBootApp.class, args);
    }

}
