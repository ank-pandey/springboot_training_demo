package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tour;
import com.example.demo.service.TourService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1/tours")
public class TourController {

	private TourService service;

	@Autowired
	public void setTourService(TourService service) {

		this.service = service;
	}

	@Operation(description = "Method used to Find all the Tours provided by SITA Tours")
	@GetMapping(path = "/")
	public List<Tour> findAll() {

		return this.service.findAll();
	}

	@Operation(description = "Method used to Find the Tour detail provided by SITA Tours for an ID")
	@GetMapping(path = "/{id}")
	public Tour findById(@PathVariable("id") int id) {

		return this.service.findById(id).orElseThrow(() -> new RuntimeException("Given Id Not Found"));
	}

	@Operation(description = "Method used to save the Tour details provided by SITA Tours")
	@PostMapping(path = "/")
	public ResponseEntity<Tour> addTour(@RequestBody Tour tour) {

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.addTour(tour));

	}

	@Operation(description = "Method used to update the Tour detail provided by SITA Tours")
	@PutMapping(path = "/")
	public Tour updateTour(@RequestBody Tour entity) {

		return this.service.updateTour(entity);
	}

	@Operation(description = "Method used to Delete the Tour detail provided by SITA Tours")
	@DeleteMapping(path = "/")
	public Tour removeTour(@RequestBody Tour entity) {

		return this.service.removeTour(entity).orElseThrow(() -> new RuntimeException("Element NOT FOUND"));

	}

	@Operation(description = "Updates the Current Cost of Tour by 10%")
	@PatchMapping(path = "/")
	public ResponseEntity<String> updateCost() {

		return ResponseEntity.status(HttpStatus.CREATED).body("Updated tours:=" + this.service.updateCost());

	}

	@Operation(description = "Method used to Search all the tours which is more than provided cost")
	@GetMapping(path = "/search/cost")
	public ResponseEntity<List<Tour>> searchByCost(@RequestParam("costValue") double costValue) {

		List<Tour> tourList = this.service.searchByCost(costValue);
		return ResponseEntity.status(HttpStatus.CREATED).body(tourList);
	}

	@Operation(description = "Method used to Search all the tours based on name")
	@GetMapping(path = "/search/tourName")
	public ResponseEntity<List<Tour>> searchByTourName(@RequestParam("tourName") String tourName) {

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.searchbyTourName(tourName));
	}
}
