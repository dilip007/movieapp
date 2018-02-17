package com.bg.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Address;
import com.bg.app.entity.AddressProjection;
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
	
	public List<AddressProjection> getAddressByDistrict(String district){
		return addressRepository.getAddressByDistrict(district);
	}
}
