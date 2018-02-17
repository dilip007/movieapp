package com.bg.app.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.engine.spi.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Actor;
import com.bg.app.entity.Film;
import com.bg.app.repository.FilmRepository;

@Service
public class FilmService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private FilmRepository filmRepository;
	
	public Iterable<Film> getAllFilm(){
		return filmRepository.findAll();
	}
	
	public List<Film> getFilmsById(int id){
		return em.createNamedQuery("Film.getMovieListByActorId").setParameter(1, id).getResultList();
		
	}
}
