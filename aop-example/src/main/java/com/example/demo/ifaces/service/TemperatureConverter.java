package com.example.demo.ifaces.service;

import org.springframework.stereotype.Component;

import com.example.demo.ifaces.Converter;

@Component
public class TemperatureConverter implements Converter {

	@Override
	public double convert(double sourceValue) {
		
		return ((sourceValue-32)*5/9);
	}

}
