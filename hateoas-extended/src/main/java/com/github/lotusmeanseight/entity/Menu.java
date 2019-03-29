package com.github.lotusmeanseight.entity;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Table;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "menu")
public class Menu extends RepresentationModel<Menu> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String menuTitle;
    private float totalPrice;
    private String shortDesc;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "menu_dishes",
    joinColumns = @JoinColumn(name = "menu_id"),
    inverseJoinColumns = @JoinColumn(name = "dish_id"))
    private List<Dish> dishes;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "menu_wines",
    joinColumns = @JoinColumn(name = "menu_id"),
    inverseJoinColumns = @JoinColumn(name = "wine_id"))
    private List<Wine> suggestedWines;


    public Menu() {
    }

    public Menu(String menuTitle, float totalPrice, String shortDesc) {
        this.menuTitle = menuTitle;
        this.totalPrice = totalPrice;
        this.shortDesc = shortDesc;
        this.suggestedWines = new ArrayList<>();
        this.dishes = new ArrayList<>();
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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Wine> getSuggestedWines() {
        return suggestedWines;
    }

    public void setSuggestedWines(List<Wine> suggestedWines) {
        this.suggestedWines = suggestedWines;
    }


}
