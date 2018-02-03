package com.bg.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.City;
import com.bg.app.entity.Staff;
import com.bg.app.repository.CityRepository;
import com.bg.app.repository.StaffRepository;

@RestController
public class LocationController {

	@Autowired
	CityRepository cityRepository; 
	
	@Autowired
	StaffRepository staffRepository;
	
	@GetMapping(value="/allcity")
	public ResponseEntity<List<City>> getAllCity(){
		List<City> cityList = new ArrayList<>();
		Iterable<City> city = cityRepository.findAll();
		city.forEach(cityList::add);
		cityList.forEach(System.out::println);
		return new ResponseEntity<List<City>>(cityList, HttpStatus.OK);
	}
	
	@GetMapping(value="/city/{cityId}")
	public ResponseEntity<City> getCityById(@PathVariable("cityId") Integer cityId){
		City city = cityRepository.findByCityId(cityId);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	@GetMapping(value="/staffs")
	public ResponseEntity<List<Staff>> getAllStaff(){
		List<Staff> staffList = new ArrayList<>();
		Iterable<Staff> staffs= staffRepository.findAll();
		staffs.forEach(staffList::add);
		return new ResponseEntity<List<Staff>>(staffList,HttpStatus.OK);
	}
}
