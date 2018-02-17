package com.bg.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.bg.app.entity.Actor;
import com.bg.app.entity.Address;
import com.bg.app.entity.Category;
import com.bg.app.entity.City;
import com.bg.app.entity.Country;
import com.bg.app.entity.Customer;
import com.bg.app.entity.Film;
import com.bg.app.entity.Inventory;
import com.bg.app.entity.Language;
import com.bg.app.entity.Payment;
import com.bg.app.entity.Rental;
import com.bg.app.entity.Staff;
import com.bg.app.entity.Store;

@Configuration
public class ExposeEntityIdRestConfiguration extends RepositoryRestConfigurerAdapter{

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Actor.class,Address.class,Category.class,
				City.class,Country.class,Customer.class,Film.class,
				Inventory.class,Language.class,Payment.class,Rental.class,Staff.class,Store.class);
	}

}
