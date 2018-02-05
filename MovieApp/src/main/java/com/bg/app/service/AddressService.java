package com.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Address;
import com.bg.app.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	public Iterable<Address> getAllAddress(){
		return addressRepository.findAll();
	}
	
	public Address getAddressById(int id) {
		return addressRepository.findOne(id);
	}
}
