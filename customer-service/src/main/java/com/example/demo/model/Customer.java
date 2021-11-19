package com.example.demo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

	int id;
	String customerName;
	String email;

	@Autowired
	Environment env;
	
	@Autowired
	//@Autowired(required = false)
	@Qualifier("ramsAddress2")
	Address billingAddress;

	public Customer() {
		super();
		//System.out.println("Environment-PORT: "+env.getProperty("server.port"));
	}

	public Customer(int id, String customerName, String email, Address billingAddress) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.billingAddress = billingAddress;
	}
	
	
	/*
	 * public void init() {
	 * System.out.println("Environment-PORT          := "+env.getProperty(
	 * "server.port")); }
	 */
	
	@PostConstruct
	public void construct() {

		System.out.println("Environment-PORT       :="+ env.getProperty("server.port"));	
	}
	@PreDestroy
	public void destroy() {

		System.out.println("DESTROY METHOD Called --------------");

		
	}
}
