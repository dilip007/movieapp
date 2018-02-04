package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Rental;

@Repository
@RepositoryRestResource(collectionResourceRel="rental",path="rental")
public interface RentalRepository extends CrudRepository<Rental, Integer>{

}
