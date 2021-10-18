package com.epam.nosql.config;

import com.epam.nosql.model.Event;
import com.epam.nosql.model.EventDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Configuration
public class BeanConfiguration {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    modelMapper.createTypeMap(Event.class, EventDto.class)
        .addMappings(m -> m.skip(EventDto::setDateTime));
    modelMapper.createTypeMap(EventDto.class, Event.class)
        .addMappings(m -> m.skip(Event::setDateTime));
    return modelMapper;
  }

}
