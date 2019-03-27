package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Integer> {
    Menu findByMenuTitle(String title);
}
