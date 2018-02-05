package com.bg.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Actor;
import com.bg.app.entity.Film;
import com.bg.app.service.ActorService;

@RestController
public class ActorControlller {

	public static final Logger LOG = Logger.getLogger(ActorControlller.class);
	
	@Autowired
	ActorService actorService;

	@PersistenceContext
	EntityManager entityManager;

	@GetMapping(value="/allactors")
	public ResponseEntity<List<Actor>> getAllActors(){
		List<Actor> actorList = new ArrayList<>();
		Iterable<Actor> actors = actorService.findAllActors();
		actors.forEach(actorList::add);
		return new ResponseEntity<List<Actor>>(actorList, HttpStatus.OK);
	}

	@GetMapping(value="/actorid/{id}")
	public Actor getActorById(@PathVariable("id") int id) {
		LOG.info("Actor id = "+id);
		Actor actor = actorService.findActorById(id);
		return actor;
	}

	@PutMapping(value="/updateactor/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateActor(@RequestBody Actor actor,@PathVariable("id") int id){
		actorService.update(actor,id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/actorfilm/{id}")
	public List<Film> getFilmsByActorById(@PathVariable("id") int id){
		List<Film> movieList = actorService.filmList(id);
		return  movieList;
	}
}
