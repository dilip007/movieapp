package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Actor;

@Repository
@RepositoryRestResource(collectionResourceRel = "actor", path = "actor")
public interface ActorRepository extends CrudRepository<Actor, Integer>{

}
