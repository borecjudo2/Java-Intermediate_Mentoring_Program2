package com.epam.aws3sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class Aws3SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aws3SenderApplication.class, args);
	}

}
