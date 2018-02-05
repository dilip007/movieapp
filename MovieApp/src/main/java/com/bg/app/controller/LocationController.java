package com.bg.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Address;
import com.bg.app.entity.City;
import com.bg.app.service.AddressService;
import com.bg.app.service.LocationService;

@RestController
public class LocationController {

	@Autowired
	LocationService locationService;
	
	@Autowired
	AddressService addressService;
	
	@GetMapping(value="/allcity")
	public ResponseEntity<List<City>> getAllCity(){
		List<City> cityList = new ArrayList<>();
		Iterable<City> city = locationService.getAllCity();
		city.forEach(cityList::add);
		return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
	}
	
	@GetMapping(value="/city/{cityId}")
	public ResponseEntity<City> getCityById(@PathVariable("cityId") int cityId){
		return new ResponseEntity<City>(locationService.getCityById(cityId), HttpStatus.OK);
	}
	
	@GetMapping(value="address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") int id){
		return new ResponseEntity<Address>(addressService.getAddressById(id),HttpStatus.OK);
	}
	
}
