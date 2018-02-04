package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Inventory;

@Repository
@RepositoryRestResource(collectionResourceRel="inventory",path="inventory")
public interface InventoryRepository extends CrudRepository<Inventory, Integer>{

}
