package com.example.qrescue.data;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;


@Entity
@Table
public class Data {
    @Id
    @SequenceGenerator(
            name = "data_sequence",
            sequenceName = "data_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "data_sequence"
    )
    private Long id_building;
    private Long num_of_residents;
    private Long fire_exits;

    public Data() {
    }

    public Data(Long id_building, Long num_of_residents, Long fire_exits) {
        this.id_building = id_building;
        this.num_of_residents = num_of_residents;
        this.fire_exits = fire_exits;
    }

    public Long getId_building() {
        return id_building;
    }

    public void setId_building(Long id_building) {
        this.id_building = id_building;
    }

    public Long getNum_of_residents() {
        return num_of_residents;
    }

    public void setNum_of_residents(Long num_of_residents) {
        this.num_of_residents = num_of_residents;
    }

    public Long getFire_exits() {
        return fire_exits;
    }

    public void setFire_exits(Long fire_exits) {
        this.fire_exits = fire_exits;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id_building=" + id_building +
                ", num_of_residents='" + num_of_residents + '\'' +
                ", fire_exits='" + fire_exits + '\'' +
                '}';
    }
}

