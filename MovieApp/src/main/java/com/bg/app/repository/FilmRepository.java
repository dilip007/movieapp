package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bg.app.entity.Film;

@RepositoryRestResource(collectionResourceRel="film",path="film")
public interface FilmRepository extends CrudRepository<Film, Integer>{

}
