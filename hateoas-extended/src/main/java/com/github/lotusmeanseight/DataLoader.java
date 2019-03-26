package com.github.lotusmeanseight;

import com.github.lotusmeanseight.entity.Wine;
import com.github.lotusmeanseight.entity.repository.WineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    CommandLineRunner init(WineRepository repository){
        return args -> {
            repository.save(new Wine("Wine", "Spätburgunder","Rotwein", 10,
                    "Wine wine wine"));
        };
    }

}
