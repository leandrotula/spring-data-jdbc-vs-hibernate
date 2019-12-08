package com.example.demospringdatajdbc.repository;

import com.example.demospringdatajdbc.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
}
