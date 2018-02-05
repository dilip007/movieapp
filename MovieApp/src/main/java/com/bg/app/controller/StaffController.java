package com.bg.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Staff;
import com.bg.app.service.StaffService;

@RestController
public class StaffController {
	
	@Autowired
	StaffService staffService;

	@GetMapping(value="/staffs")
	public ResponseEntity<List<Staff>> getAllStaff(){
		List<Staff> staffList = new ArrayList<>();
		Iterable<Staff> staffs= staffService.findAllStaff();
		staffs.forEach(staffList::add);
		return new ResponseEntity<List<Staff>>(staffList,HttpStatus.OK);
	}
}
