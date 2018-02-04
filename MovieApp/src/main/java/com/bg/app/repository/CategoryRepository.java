package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Category;

@Repository
@RepositoryRestResource(collectionResourceRel="category",path="category")
public interface CategoryRepository extends CrudRepository<Category, Integer>{

}
