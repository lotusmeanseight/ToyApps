package com.github.lotusmeanseight.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private Integer id;
    private String menuTitle;
    private float totalPrice;
    private String shortDesc;
    @ManyToMany
    private Set<Dish> dishes;
    @ManyToMany
    private Set<Wine> suggestedWines;


    public Menu() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Set<Wine> getSuggestedWines() {
        return suggestedWines;
    }

    public void setSuggestedWines(Set<Wine> suggestedWines) {
        this.suggestedWines = suggestedWines;
    }


}
