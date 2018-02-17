package com.bg.app.entity;

import org.springframework.data.rest.core.config.Projection;

import com.bg.app.entity.Address;

@Projection(name="addressProjection",types=Address.class)
public interface AddressProjection {

	String getAddress();
	String getDistrict();
	String getPostalCode();
	String getPhone();
}
