package com.example.demospringdatajdbc.model;

import org.springframework.data.annotation.Id;

public class Car {

    @Id
    private Long id;

    private String brand;

    private Long person;

    public Car(Long id, String brand, Long person) {
        this.id = id;
        this.brand = brand;
        this.person = person;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }
}
