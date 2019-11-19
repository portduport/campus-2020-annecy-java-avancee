package com.campus2020.projetJavaAvancee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjetJavaAvanceeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetJavaAvanceeApplication.class, args);
	}

}
