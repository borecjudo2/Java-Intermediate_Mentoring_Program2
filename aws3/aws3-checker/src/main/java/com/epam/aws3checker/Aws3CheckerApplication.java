package com.epam.aws3checker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class Aws3CheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aws3CheckerApplication.class, args);
	}

}
