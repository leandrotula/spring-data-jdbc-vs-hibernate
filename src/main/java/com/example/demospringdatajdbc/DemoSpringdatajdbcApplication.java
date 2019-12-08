package com.example.demospringdatajdbc;

import com.example.demospringdatajdbc.model.Car;
import com.example.demospringdatajdbc.model.Person;
import com.example.demospringdatajdbc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DemoSpringdatajdbcApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringdatajdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person personWithPeugeotBrand = new Person();
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
		personWithVw.setName("Carolina");
		personWithVw.setLastName("Glatste");
		Set<Car> vwCars = new HashSet<>();
		Car vwCar = new Car();
		vwCar.setPerson(personWithVw);
		vwCar.setBrand("VW golf 2.0");
		vwCars.add(vwCar);
		personWithVw.setCars(vwCars);
		personRepository.save(personWithVw);

		personRepository.findAll().forEach(data -> data.getCars().stream().map(Car::getBrand).forEach(System.out::println));


	}
}
