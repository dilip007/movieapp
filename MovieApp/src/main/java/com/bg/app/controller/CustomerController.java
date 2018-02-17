package com.bg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Customer;
import com.bg.app.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/allcustomer")
	public Iterable<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
}
