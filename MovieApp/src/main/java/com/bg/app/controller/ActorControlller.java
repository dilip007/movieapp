package com.bg.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Actor;
import com.bg.app.repository.ActorRepository;

@RestController
public class ActorControlller {

	@Autowired
	ActorRepository actorRepository;

	@GetMapping(value="/allactors")
	public ResponseEntity<List<Actor>> getAllActors(){
		List<Actor> actorList = new ArrayList<>();
		Iterable<Actor> actors = actorRepository.findAll();
		actors.forEach(actorList::add);
		return new ResponseEntity<List<Actor>>(actorList, HttpStatus.OK);
	}

}
