package com.example.demospringdatajdbc;

import com.example.demospringdatajdbc.model.Car;
import com.example.demospringdatajdbc.model.Person;
import com.example.demospringdatajdbc.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class DemoSpringdatajdbcApplication implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoSpringdatajdbcApplication.class);

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringdatajdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		final Set<Person> all = personRepository.findAll();
		all.forEach(person -> {
			//LOGGER.info(String.join("-", person.getName(), person.getLastName()));
			final Set<Car> cars = person.getCars();
			cars.forEach(car -> LOGGER.info(car.getBrand()));
		});

	}
}
