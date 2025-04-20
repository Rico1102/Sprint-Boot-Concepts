package com.r1c0.SpringBootConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConceptsApplication.class, args);
	}

}
