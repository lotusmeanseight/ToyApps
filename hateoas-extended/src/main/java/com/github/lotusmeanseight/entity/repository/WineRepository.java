package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Wine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WineRepository extends CrudRepository<Wine, Integer> {
    List<Wine> findByBrand(String brand);
    List<Wine> findFirstByAgeOrderByAgeAsc(int age);
    Wine findByBrandAndTypeAndName(String brand, String type, String name);
}
