package com.github.lotusmeanseight.entity;

import com.google.common.base.Objects;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation extends RepresentationModel<Reservation> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToMany(mappedBy = "reservation")
    private List<Table> tableList;
    @ManyToOne
    private Customer customer;
    private String title;
    private String note;

    public Reservation(){

    }

    public Reservation(Customer customer, String title, String note) {
        this.customer = customer;
        this.title = title;
        this.note = note;
        this.tableList = new ArrayList<>();
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Reservation that = (Reservation) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(customer, that.customer) &&
                Objects.equal(title, that.title) &&
                Objects.equal(note, that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), id, customer, title, note);
    }
}
