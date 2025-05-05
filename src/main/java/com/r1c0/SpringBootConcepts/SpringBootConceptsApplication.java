package com.r1c0.SpringBootConcepts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan(basePackages = "com.r1c0.SpringBootConcepts.AOP")
public class SpringBootConceptsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConceptsApplication.class, args);
	}

}
