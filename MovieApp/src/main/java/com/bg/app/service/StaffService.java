package com.bg.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Staff;
import com.bg.app.repository.StaffRepository;

@Service
public class StaffService {
	
	@Autowired
	StaffRepository staffRepository;
	
	public Iterable<Staff> findAllStaff() {
		return staffRepository.findAll();
	}

}
