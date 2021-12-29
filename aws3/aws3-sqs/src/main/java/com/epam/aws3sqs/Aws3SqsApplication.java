package com.epam.aws3sqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class Aws3SqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Aws3SqsApplication.class, args);
	}

}
