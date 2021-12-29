package com.epam.aws2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@SpringBootApplication
public class Aws2Application {

	public static void main(String[] args) {
		SpringApplication.run(Aws2Application.class, args);
	}

	@GetMapping("aws")
	public String printHelloAWS() {
		return "Hello AWS!";
	}

}
