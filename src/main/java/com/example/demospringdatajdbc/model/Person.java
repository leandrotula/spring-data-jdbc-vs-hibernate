package com.example.demospringdatajdbc.model;

import org.springframework.data.annotation.Id;

import java.util.Set;

public class Person {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private Set<Car> cars;

    public Person(Long id, String name, String lastName, Set<Car> cars) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cars=" + cars +
                '}';
    }
}
