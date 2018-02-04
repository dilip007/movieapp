package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Country;

@Repository
@RepositoryRestResource(collectionResourceRel="country",path="country")
public interface CountryRepository extends CrudRepository<Country, Integer>{

}
