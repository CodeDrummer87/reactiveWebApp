package com.example.reactiveWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ReactiveWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveWebAppApplication.class, args);
	}

}
