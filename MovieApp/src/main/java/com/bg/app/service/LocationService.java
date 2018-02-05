package com.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.City;
import com.bg.app.repository.CityRepository;

@Service
public class LocationService {

	@Autowired
	CityRepository cityRepository; 
	
	public Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}
	
	public City getCityById(int id) {
		return cityRepository.findByCityId(id);
	}
	
}
