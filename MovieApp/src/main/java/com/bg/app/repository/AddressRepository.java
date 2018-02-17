package com.bg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Address;
import com.bg.app.entity.AddressProjection;

@Repository
@RepositoryRestResource(collectionResourceRel="address",path="address",excerptProjection=AddressProjection.class)
public interface AddressRepository extends CrudRepository<Address, Integer>{

	@Query(value="SELECT a from Address a where district =:district")
	List<AddressProjection> getAddressByDistrict(@Param("district") String district); 
	
}
