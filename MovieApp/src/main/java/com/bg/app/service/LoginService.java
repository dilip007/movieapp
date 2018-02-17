package com.bg.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bg.app.entity.Login;
import com.bg.app.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Transactional
	public boolean saveSignUp(Login login) {
		String email = login.getEmail();
		if(loginRepository.existsByEmail(email)) {
			return false;
		}
		else {
			loginRepository.save(login);
		}
		return true;
	}

	/*@Transactional
	public void updateSignUpInfo() {
		Login updateLogin = loginRepository.findOne(203);
		updateLogin.setEmail("dilip@gmail.com");
		loginRepository.save(updateLogin);
	}*/

}
