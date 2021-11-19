package com.example.demo;

import java.util.Map;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Tour;
import com.example.demo.model.TourCatalog;

//@SpringBootApplication(exclude = BatchAutoConfiguration.class)
@SpringBootApplication
public class TourServiceApplication {

	public static void main(String[] args) {

		/**
		 * The First Argument is a Class annotated with @SpringBootApplication , in this
		 * the TourServiceApplication itself has @SpringBootApplication hence its passed
		 * as a argument i.e any Class annotated with @SpringBootApplication can be
		 * passed as an argument
		 * 
		 * The Second Argument is command Line arguments passed to the main method
		 * 
		 * The return type of run method is a IoC container
		 * 
		 */

		ConfigurableApplicationContext context = SpringApplication.run(TourServiceApplication.class, args);

//		ConfigurableApplicationContext context=  new SpringApplicationBuilder(TourServiceApplication.class)
//	     .properties("spring.main.allow-bean-definition-overriding:true").build().run(args);

		Map<String, TourCatalog> beanList = context.getBeansOfType(TourCatalog.class);

		Set<Map.Entry<String, TourCatalog>> list = beanList.entrySet();

		for (Map.Entry<String, TourCatalog> eachItem : list) {

			System.out.println(eachItem.getKey() + "=:=" + eachItem.getValue());
		}

		/*
		 * Tour tour = (Tour) context.getBean("tour");
		 * 
		 * System.out.println(tour);
		 */

		Tour lankaTour = (Tour) context.getBean("lankaTour");

		System.out.println(lankaTour);

		/*
		 * Tour tour1 = (Tour) context.getBean("tour", Tour.class);
		 * 
		 * System.out.println(tour1);
		 */

		/*
		 * System.out.println(context.getClass().getName());
		 * 
		 * TourCatalog catalog = context.getBean(TourCatalog.class);
		 * System.out.println(catalog);
		 */

		System.out.println(context.getClass().getName());

		TourCatalog euroCatalog = context.getBean("europeTour", TourCatalog.class);

		System.out.println(euroCatalog);

		TourCatalog asiaCatalog = context.getBean("eastAsiaTour", TourCatalog.class);

		System.out.println(asiaCatalog);

	}
}
