package com.github.lotusmeanseight.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wine_id")
    private Integer id;
    @OneToMany(mappedBy = "reservation")
    private List<Table> tableList;
    @ManyToOne
    private Customer customer;

    public Reservation(){

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
