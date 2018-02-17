package com.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Customer;
import com.bg.app.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public Iterable<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	
}
