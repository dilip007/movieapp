package com.bg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Rental;
import com.bg.app.entity.RentalProjection;
import com.bg.app.service.RentalService;

@RestController
public class RentalController {

	@Autowired
	private RentalService rentalService;
	
	@GetMapping(value="/allrental")
	public Iterable<Rental> getAllRental(){
		return rentalService.getAllRental();
	}
	
	@GetMapping(value="rental/{id}")
	public Rental getRentalById(@PathVariable("id") Integer id) {
		return rentalService.getRentalById(id);
	}
}
