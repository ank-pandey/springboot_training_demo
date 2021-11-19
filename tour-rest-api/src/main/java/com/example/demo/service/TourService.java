package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Tour;
import com.example.demo.repo.TourRepository;

@Service
public class TourService {

	private TourRepository repository;

	@Autowired
	public void setRepository(TourRepository repository) {
		this.repository = repository;
	}

	public List<Tour> findAll() {

		return this.repository.findAll();
	}

	public Optional<Tour> findById(int id) {

		return this.repository.findById(id);
	}

	public Tour addTour(Tour entity) {

		return this.repository.save(entity);
	}

	public Tour updateTour(Tour entity) {

		return this.repository.save(entity);
	}

	public Optional<Tour> removeTour(Tour tour) {

		Optional<Tour> optional = Optional.empty();

		if (this.repository.existsById(tour.getId())) {

			this.repository.delete(tour);

			optional = Optional.of(tour);
		}

		return optional;
	}

	public int updateCost() {

		return this.repository.updateCost();
	}

	public List<Tour> searchByCost(double costValue) {

		return this.repository.getToursGreaterThanCost(costValue);
	}

	public List<Tour> searchbyTourName(String name) {
		
		return this.repository.findByTourName(name);
	}
}