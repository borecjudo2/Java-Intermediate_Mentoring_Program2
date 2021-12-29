package com.epam.aws3sqs.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Configuration
public class Config {

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
