package com.epam.client;

import com.epam.client.model.mapper.OrderMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Bean
	public NewTopic order(@Value("${topic.order.name}") String order) {
		return new NewTopic(order,3, (short) 1);
	}

	@Bean
	public NewTopic notification(@Value("${topic.notification.name}") String notification) {
		return new NewTopic(notification,3, (short) 1);
	}

	@Bean
	public OrderMapper orderMapper() {
		return OrderMapper.INSTANCE;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

}
