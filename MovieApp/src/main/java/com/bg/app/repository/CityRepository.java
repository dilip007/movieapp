package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.City;

@Repository
@RepositoryRestResource(collectionResourceRel = "city", path = "city")

public interface CityRepository extends CrudRepository<City, Integer>{
	
}
