package com.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.City;
import com.bg.app.entity.Country;
import com.bg.app.repository.CityRepository;
import com.bg.app.repository.CountryRepository;

@Service
public class LocationService {

	@Autowired
	CityRepository cityRepository; 
	
	@Autowired
	CountryRepository countryRepository;
	
	public Iterable<City> getAllCity(){
		return cityRepository.findAll();
	}
	
	public City getCityById(int id) {
		return cityRepository.findOne(id);
	}
	
	public Country getCountryById(int id) {
		return countryRepository.findOne(id);
	}
}
