package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Customer;

@Repository
@RepositoryRestResource(collectionResourceRel="customer",path="customer")
public interface CustomerRepository extends CrudRepository<Customer, Integer>{

}
