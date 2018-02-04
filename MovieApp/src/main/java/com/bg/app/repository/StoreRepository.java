package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Store;

@Repository
@RepositoryRestResource(collectionResourceRel="store",path="store")
public interface StoreRepository extends CrudRepository<Store, Integer>{

}
