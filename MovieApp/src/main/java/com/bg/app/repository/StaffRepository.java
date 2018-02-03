package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Staff;

@Repository
@RepositoryRestResource(collectionResourceRel="staff",path="staff")
public interface StaffRepository extends CrudRepository<Staff, Integer>{

}
