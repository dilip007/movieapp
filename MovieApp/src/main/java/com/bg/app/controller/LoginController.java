package com.bg.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bg.app.entity.Login;
import com.bg.app.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping(value="/signup")
	public ResponseEntity<String> createSignUp(@RequestBody Login login){
		try {
			boolean signUp = loginService.saveSignUp(login);
			if(signUp) {
				return new ResponseEntity<String>("created",HttpStatus.CREATED);
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity<String>("email with user already exists",HttpStatus.CONFLICT);
	}

}
