package com.example.eliza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ElizaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElizaApplication.class, args);
	}

	@GetMapping
	public String Greeting() {
		return "Hello World";
	}

}
