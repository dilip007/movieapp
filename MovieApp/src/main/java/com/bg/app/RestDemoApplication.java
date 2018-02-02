package com.bg.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaRepositories
@EnableSpringDataWebSupport
@EnableTransactionManagement
@EnableWebMvc
public class RestDemoApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(RestDemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("App started");
	}
}
