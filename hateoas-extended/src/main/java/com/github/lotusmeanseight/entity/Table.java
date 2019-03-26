package com.github.lotusmeanseight.entity;

import com.google.common.base.Objects;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "restaurant_table")
public class Table extends RepresentationModel<Table> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Reservation reservation;

    public Table(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equal(id, table.id) &&
                Objects.equal(reservation, table.reservation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, reservation);
    }
}
