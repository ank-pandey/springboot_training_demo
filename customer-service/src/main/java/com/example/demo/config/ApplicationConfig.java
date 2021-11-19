package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import com.example.demo.model.Address;
import com.example.demo.model.Customer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ApplicationConfig {
	
	@Bean
	@Primary
	@Lazy(value = true)
	public Address ramsAddress() {
		log.info("Calling Factory method ramAddress()************************");
		return new Address("Gandhi Street", "nehru nagar", "Pune", 230131);
	}
	
	@Bean
	@Lazy(value = true)
	public Address ramsAddress2() {
		log.info("Calling Factory method ramAddress2()###############################");
		return new Address("ShivaJi Street", "Indira nagar", "Pune", 230304);
	}
	
	//@Bean(initMethod = "init")
	@Bean
	@Lazy(value = true)
	//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Customer ram() {
		
		log.info("Calling Factory method ram()==========================");
		Customer ram = new Customer();
		ram.setId(1020);
		ram.setCustomerName("Ram Kumar");
		ram.setEmail("ram@abc.com");
		return ram;
	}

}
