package com.bg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Film;
import com.bg.app.service.FilmService;

@RestController
//@CrossOrigin(origins="*")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@GetMapping(value="/allfilm")
	public Iterable<Film> getAllFilm(){
		return filmService.getAllFilm();
	}

	@GetMapping(value="/filmid/{id}")
	public List<Film> getFilmsById(@PathVariable("id")int id){
		return filmService.getFilmsById(id);
	}
}
