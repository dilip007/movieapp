package com.bg.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bg.app.entity.Login;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer>{

	boolean existsByEmail(String email);
	
}
