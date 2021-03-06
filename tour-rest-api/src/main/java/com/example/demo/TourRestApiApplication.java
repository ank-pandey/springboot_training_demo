package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Tour;
import com.example.demo.repo.TourRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title = "Tour & Travels API",version = "1.0"))
public class TourRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourRestApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {

		return new CommandLineRunner() {

			@Autowired
			TourRepository repo;

			@Override
			public void run(String... args) throws Exception {

				repo.save(new Tour(101, "Simla", 56000));
				repo.save(new Tour(102, "Jammu", 76000));

			}
		};
	}

}
