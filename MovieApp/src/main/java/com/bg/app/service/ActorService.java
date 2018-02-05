package com.bg.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Actor;
import com.bg.app.entity.Film;
import com.bg.app.repository.ActorRepository;

@Service
public class ActorService {

	private static final int PARAMETER = 1;

	@Autowired
	private ActorRepository actorRepository;

	@PersistenceContext
	EntityManager em;

	@Transactional
	public void update(Actor actor,int id) {
		Actor updateActor = actorRepository.findOne(id);
		updateActor.setFirstName(actor.getFirstName());
		updateActor.setLastName(actor.getLastName());
		actorRepository.save(updateActor);
	}
	
	public Iterable<Actor> findAllActors(){
		return actorRepository.findAll();
	}
	
	public Actor findActorById(int id) {
		return actorRepository.findOne(id);
	}

	public List<Film> filmList(int id){
		return em.createNamedQuery("getMovieListByActorId", Film.class).setParameter(PARAMETER, id).getResultList();
	}



}
