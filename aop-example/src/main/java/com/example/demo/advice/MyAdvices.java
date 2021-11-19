package com.example.demo.advice;

import java.time.LocalDate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import lombok.extern.slf4j.Slf4j;

@Aspect
@EnableAspectJAutoProxy
@Configuration
@Slf4j
public class MyAdvices {
	
	@Before(value = "execution(* com.example.demo.ifaces.service.*.*(..))")
	public void loggingAdvice(JoinPoint jp) {
		
		log.info("========================== "+jp.getSignature().getName()+" "+LocalDate.now());
		
	}
	
	@Around(value = "execution(* com.example.demo.ifaces.service.CurrencyConverter.*(..))")
	public Double offerAdvice(ProceedingJoinPoint pj) throws Throwable {
		
		Object[] args = pj.getArgs();
		log.info("Currency value to convert:= "+args[0]);
		
		Object value = pj.proceed();
		
		Double updatedValue = (Double)value;
		
		return updatedValue+99;
		
	}

}
