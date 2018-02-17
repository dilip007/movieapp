package com.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Rental;
import com.bg.app.entity.RentalProjection;
import com.bg.app.repository.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	public Iterable<Rental> getAllRental(){
		return rentalRepository.findAll();
	}
	
	public Rental getRentalById(Integer id) {
		return rentalRepository.findByRentId(id);
	}
}
