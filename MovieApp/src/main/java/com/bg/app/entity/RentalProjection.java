package com.bg.app.entity;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="rentalProjection",types=Rental.class)
public interface RentalProjection {

	Date getRentalDate();
	Date getReturnDate();
	
	Customer getCustomer();
	interface Customer{
		String getFirstName();
		String getLastName();
	}
	
	Staff getStaff();
	interface Staff{
		String getFirstName();
		String getLastName();
	}
	
}
