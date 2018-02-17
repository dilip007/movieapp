package com.bg.app.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Rental;
import com.bg.app.entity.RentalProjection;

@Repository
@RepositoryRestResource(collectionResourceRel="rental",path="rental",excerptProjection=RentalProjection.class)
public interface RentalRepository extends CrudRepository<Rental, Integer>{

	@Query(value="SELECT re from Rental re where re.rental_id=:rentId)")
	Rental findByRentId(@Param("rentId")Integer id);
}
