package com.github.lotusmeanseight.entity;

import com.google.common.base.Objects;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dish extends RepresentationModel<Dish> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String name;
    private int calories;
    @ManyToMany(mappedBy = "dishes")
    private List<Menu> menus;
    private boolean vegetarian;
    private boolean lactose;
    private boolean gluten;

    public Dish(){

    }

    public Dish(String name, int calories, boolean vegetarian, boolean lactose, boolean gluten) {
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.lactose = lactose;
        this.gluten = gluten;
        this.menus = new ArrayList<>();
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

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menuSet) {
        this.menus = menuSet;
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
