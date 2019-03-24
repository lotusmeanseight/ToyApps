package com.github.lotusmeanseight.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dish_id")
    private Integer id;
    private String name;
    private int calories;
    @ManyToMany
    private Set<Menu> menuSet;
    private boolean vegetarian;
    private boolean lactose;
    private boolean gluten;

    public Dish(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isLactose() {
        return lactose;
    }

    public void setLactose(boolean lactose) {
        this.lactose = lactose;
    }

    public boolean isGluten() {
        return gluten;
    }

    public void setGluten(boolean gluten) {
        this.gluten = gluten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return calories == dish.calories &&
                vegetarian == dish.vegetarian &&
                lactose == dish.lactose &&
                gluten == dish.gluten &&
                Objects.equal(id, dish.id) &&
                Objects.equal(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, calories, vegetarian, lactose, gluten);
    }
}
