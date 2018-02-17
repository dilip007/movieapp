package com.bg.app.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="staffProjection",types=Staff.class)
public interface StaffProjection {

	String getFirstName();
	String getLastName();
	Address getAddress();
	
	interface Address{
		String getAddress();
	}
}
