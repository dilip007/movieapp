package com.bg.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Actor;
import com.bg.app.repository.ActorRepository;
import com.bg.app.service.ActorService;

@RestController
public class ActorControlller {

	@Autowired
	ActorRepository actorRepository;
	
	@Autowired
	ActorService actorService;

	@GetMapping(value="/allactors")
	public ResponseEntity<List<Actor>> getAllActors(){
		List<Actor> actorList = new ArrayList<>();
		Iterable<Actor> actors = actorRepository.findAll();
		actors.forEach(actorList::add);
		return new ResponseEntity<List<Actor>>(actorList, HttpStatus.OK);
	}

	@GetMapping(value="/id/{id}")
	public Actor getActorById(@PathVariable("id") int id) {
		System.out.println("id = "+id);
		Actor actor = actorRepository.findOne(id);
		return actor;
	}

	@PutMapping(value="/updateactor",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateActor(@RequestBody Actor actor){
		//actor.saveOrUpdate();
		actorService.update(actor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
