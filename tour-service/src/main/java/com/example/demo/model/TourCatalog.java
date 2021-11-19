package com.example.demo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

//@Component
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TourCatalog {

	Tour tour;
	TourAgent agent;
	
	// Constructor DI
	//@Autowired
	public TourCatalog(Tour tour, TourAgent agent) {
		super();
		this.tour = tour;
		this.agent = agent;
	}

	 //  @Autowired
	 public void setTour(Tour tour) {
		this.tour = tour;
	}

    //@Autowired
	public void setAgent(TourAgent agent) {
		this.agent = agent;
	}
}
