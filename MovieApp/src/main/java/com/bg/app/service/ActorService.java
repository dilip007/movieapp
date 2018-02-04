package com.bg.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Actor;
import com.bg.app.repository.ActorRepository;

@Service
public class ActorService {
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Transactional
	public void update(Actor t) {
		actorRepository.save(t);
	}
	

}
