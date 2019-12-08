package com.example.demospringdatajdbc.repository;

import com.example.demospringdatajdbc.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Set<Person> findAll();
}
