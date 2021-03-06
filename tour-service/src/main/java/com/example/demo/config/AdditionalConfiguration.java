package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Tour;
import com.example.demo.model.TourAgent;

@Configuration
public class AdditionalConfiguration {
	
	@Bean
	public Tour thailandTour() {
		
		return new Tour(102, "Thailand", 75000);
	}
	
	@Bean
	public TourAgent agent2() {
		
		return new TourAgent(201, "Manish", 767676767, "Mumbai");
	}

}
