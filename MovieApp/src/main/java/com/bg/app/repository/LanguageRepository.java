package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Language;

@Repository
@RepositoryRestResource(collectionResourceRel="language",path="language")
public interface LanguageRepository extends CrudRepository<Language, Integer>{

}
