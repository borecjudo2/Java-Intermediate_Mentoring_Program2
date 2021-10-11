package com.epam.restapi;

import model.Event;
import model.EventDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.EventService;
import service.impl.EventServiceImpl;

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


  @Bean
  public EventService eventService() {
    return new EventServiceImpl();
  }

}
