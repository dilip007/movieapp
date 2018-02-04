package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Address;

@Repository
@RepositoryRestResource(collectionResourceRel="address",path="address")
public interface AddressRepository extends CrudRepository<Address, Integer>{

}
