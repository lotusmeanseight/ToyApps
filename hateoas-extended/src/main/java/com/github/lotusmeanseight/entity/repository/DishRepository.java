package com.github.lotusmeanseight.entity.repository;

import com.github.lotusmeanseight.entity.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    List<Dish> findByCaloriesBetween(int min, int max);
    List<Dish> findByCaloriesBetweenAndVegetarian(int min, int max);
    List<Dish> findByCaloriesBetweenAndGluten(int min, int max);
    List<Dish> findByCaloriesBetweenAndLactose(int min, int max);
    List<Dish> findByCaloriesOrderByCaloriesAsc(int calories);
    Dish findByName(String name);
}
