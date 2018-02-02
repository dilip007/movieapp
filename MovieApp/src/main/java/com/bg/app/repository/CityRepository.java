package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.bg.app.entity.City;

public interface CityRepository extends CrudRepository<City, Integer>{
    City findByCityId(Integer cityId);
}
