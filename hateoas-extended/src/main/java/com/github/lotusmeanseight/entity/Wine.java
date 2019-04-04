package com.github.lotusmeanseight.entity;

import com.google.common.base.Objects;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Wine extends RepresentationModel<Wine> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String brand;
    private String type;
    private int age;
    private String shortDesc;
    @ManyToMany(mappedBy = "suggestedWines")
    private List<Menu> menus;

    public Wine(){
    }

    public Wine(String name, String brand, String type, int age, String shortDesc) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.age = age;
        this.shortDesc = shortDesc;
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine wine = (Wine) o;
        return age == wine.age &&
                Objects.equal(id, wine.id) &&
                Objects.equal(name, wine.name) &&
                Objects.equal(brand, wine.brand) &&
                Objects.equal(type, wine.type) &&
                Objects.equal(shortDesc, wine.shortDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, brand, type, age, shortDesc);
    }
}
