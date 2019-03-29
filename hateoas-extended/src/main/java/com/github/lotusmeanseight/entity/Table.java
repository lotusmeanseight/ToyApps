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
    private int numberOfSeats;
    private boolean deluxe;

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

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public boolean isDeluxe() {
        return deluxe;
    }

    public void setDeluxe(boolean deluxe) {
        this.deluxe = deluxe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Table table = (Table) o;
        return numberOfSeats == table.numberOfSeats &&
                deluxe == table.deluxe &&
                Objects.equal(id, table.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), id, numberOfSeats, deluxe);
    }
}
