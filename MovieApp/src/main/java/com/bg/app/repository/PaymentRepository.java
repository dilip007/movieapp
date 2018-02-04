package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Payment;

@Repository
@RepositoryRestResource(collectionResourceRel="payment",path="payment")
public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
