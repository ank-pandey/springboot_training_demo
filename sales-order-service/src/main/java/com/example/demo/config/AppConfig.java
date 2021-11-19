package com.example.demo.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;
import com.example.demo.model.Item;
import com.example.demo.model.SalesOrder;

@Configuration
public class AppConfig {
	
	@Bean
	public Customer customer() {
		
		return new Customer(1020,"Name placeholder", "email@email.com");
	}
	
	@Bean
	public Item item1() {
		Item item = new Item();
		item.setId(1210);
		item.setItemName("firstItem");
		return item;
	}
	
	@Bean
	public Item item2() {
		Item item = new Item();
		item.setId(1220);
		item.setItemName("secondItem");
		return item;
	}

	@Bean
	public SalesOrder sales() {
		
		SalesOrder sale = new SalesOrder();
		sale.setOrderId(121);
		sale.setCreateDate(LocalDate.now());
		return sale;
	}
}
