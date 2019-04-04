package com.github.lotusmeanseight.entity;

import com.github.lotusmeanseight.entity.repository.DishRepository;
import com.github.lotusmeanseight.entity.repository.MenuRepository;
import com.github.lotusmeanseight.entity.repository.WineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class MenuTest {

    @Autowired
    private WineRepository wineRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private DishRepository dishRepository;

    @Test
    public void wineAppearsOnMenu(){
        Wine wine = new Wine("Baden", "Spätburgunder","Rotwein", 10,
                "Wine wine wine");
        Menu menu = new Menu("simple", 100.0f, "Menu menu menu");
        menu.getSuggestedWines().add(wine);
        wineRepository.save(wine);
        menuRepository.save(menu);
        Assertions.assertTrue(menuRepository.findByMenuTitle("simple").getSuggestedWines().contains(wine));
    }

    @Test
    public void dishAppearsOnMenu(){
        Dish dish = new Dish("Spaghetti", 3000, false, true, true);
        Menu menu = new Menu("simple", 100.0f, "Menu menu menu");
        menu.getDishes().add(dish);
        dishRepository.save(dish);
        menuRepository.save(menu);
        Assertions.assertTrue(menuRepository.findByMenuTitle("simple").getDishes().contains(dish));

    }

}
