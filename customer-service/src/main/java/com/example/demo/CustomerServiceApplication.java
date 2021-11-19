package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.model.Customer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class CustomerServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CustomerServiceApplication.class, args);
		
		/**  Field Injection 
		  * 
		  *  AutoWire - Matching - One Bean - 1  => works fine
		  *  AutoWire - Matching - More than One Bean -N   - Exception
		  *     => solution -1  declaring one bean with @Bean and @Primary
		  *     => Solution -2  Declaring @Autowired with @Qaulifier("nameofBean") 
		  *     => If we apply @Primary & @Qualifier both together, @Qualifier will take the precedence. 
		  *  AutoWire - Matching - NO Bean -0   - Exception
		  *      => Throws Exception => Declare a Bean 
		  *      => Declare @Autowired(required=false) exception will not be thrown but need to do a null check
		  */
		
		/**
		 * Eager Initialization => default for all Singleton Beans
		 * can make Lazy by defining as @Lzay(value = true)
		 * 
		 * Lazy Initialization => Default for all Prototype Beans
		 * 
		 */
		
		
		  Customer ram = context.getBean(Customer.class);
		  
		  log.info(ram.toString());
		  
		  boolean singleton = context.isSingleton("ram");
		  System.out.println("bean check for singleton: "+ singleton);
		  
		  boolean prototype = context.isPrototype("ram");
		  System.out.println("bean check for prototype: "+ prototype);
		  
		  context.close();
		 
	}

}
