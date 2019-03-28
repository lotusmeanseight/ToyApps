package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
    Menu findByMenuTitle(String title);
    List<Menu> findByTotalPriceOrderByTotalPriceAsc(int totalPrice);
}
