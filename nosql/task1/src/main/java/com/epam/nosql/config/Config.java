package com.epam.nosql.config;

import com.epam.nosql.mapper.EventMapper;
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
  public EventMapper eventMapper() {
    return EventMapper.INSTANCE;
  }
}
