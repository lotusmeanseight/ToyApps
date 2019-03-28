package com.github.lotusmeanseight.testentity;

import com.github.lotusmeanseight.entity.Menu;
import com.github.lotusmeanseight.entity.Wine;
import com.github.lotusmeanseight.entity.repository.MenuRepository;
import com.github.lotusmeanseight.entity.repository.WineRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class WineTest {

    @Autowired
    private WineRepository wineRepository;
    @Autowired
    private MenuRepository menuRepository;

    @Test
    public void wineAppearsOnMenu(){
        Wine wine = new Wine("Baden", "Spätburgunder","Rotwein", 10,
                "Wine wine wine");
        Menu menu = new Menu("simple", 100.0f, "Menu menu menu");
        menu.getSuggestedWines().add(wine);
        wineRepository.save(wine);
        menuRepository.save(menu);
        Assertions.assertTrue(menuRepository.findByMenuTitle("simple").getSuggestedWines().contains(wine));
        wineRepository.delete(wine);
        menuRepository.delete(menu);
    }


}
