package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.ifaces.Converter;

@SpringBootApplication
public class AopExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(AopExampleApplication.class, args);

		Converter currencyConverter = ctx.getBean("currencyConverter", Converter.class);

		System.out.println(currencyConverter.getClass().getName());
		System.out.println(currencyConverter.convert(100));

		Converter temperatureConverter = ctx.getBean("temperatureConverter", Converter.class);

		System.out.println(temperatureConverter.getClass().getName());
		System.out.println(temperatureConverter.convert(800));
	}

}
