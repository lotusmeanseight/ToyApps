package com.github.lotusmeanseight.entity;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wine_id")
    private Integer id;
    private String name;
    private String shortDesc;
    @ManyToMany(mappedBy = "suggestedWines")
    private Set<Menu> menus;

    public Wine(){

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

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wine wine = (Wine) o;
        return Objects.equal(id, wine.id) &&
                Objects.equal(name, wine.name) &&
                Objects.equal(shortDesc, wine.shortDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, shortDesc);
    }
}
