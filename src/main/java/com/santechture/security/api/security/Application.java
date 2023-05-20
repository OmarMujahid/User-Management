package com.santechture.security.api.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.santechture.security.api.security.controller","com.santechture.security.api.security", "com.santechture.security.data"})
@EnableJpaRepositories(basePackages = { "com.santechture.security.data.repository" })
@EntityScan("com.santechture.security.data.model")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
