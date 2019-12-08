package com.example.demospringdatajdbc.repository;

import com.example.demospringdatajdbc.model.Car;
import com.example.demospringdatajdbc.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Before
    public void init() {

        Person personWithPeugeotBrand = new Person();
        personWithPeugeotBrand.setId(1L);
        personWithPeugeotBrand.setName("Julio");
        personWithPeugeotBrand.setLastName("Estevez");
        Set<Car> peugeotsCars = new HashSet<>();
        Car peugeotCar = new Car();
        peugeotCar.setPerson(personWithPeugeotBrand);
        peugeotCar.setBrand("Peugeot 308 Allure pack 1.6");
        peugeotsCars.add(peugeotCar);
        personWithPeugeotBrand.setCars(peugeotsCars);
        personRepository.save(personWithPeugeotBrand);

        Person personWithVw = new Person();
        personWithVw.setId(2L);
        personWithVw.setName("Carolina");
        personWithVw.setLastName("Glatste");
        Set<Car> vwCars = new HashSet<>();
        Car vwCar = new Car();
        vwCar.setPerson(personWithVw);
        vwCar.setBrand("VW golf 2.0");
        vwCars.add(vwCar);
        personWithVw.setCars(vwCars);
        personRepository.save(personWithVw);
    }

    @Test
    public void shouldRetrieveSavedData() {

        Optional<Person> found = personRepository.findById(1L);
        Assertions.assertNotNull(found);
        Assertions.assertTrue(found.isPresent());
        found.ifPresent(person -> {
            Assertions.assertEquals("Julio", person.getName());
            Assertions.assertEquals("Estevez", person.getLastName());
        });

    }
}
