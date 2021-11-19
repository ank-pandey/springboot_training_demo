package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.SalesOrder;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SalesOrderServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SalesOrderServiceApplication.class, args);
		
		SalesOrder sales = context.getBean(SalesOrder.class);
		 log.info(sales.toString());
	}
}
