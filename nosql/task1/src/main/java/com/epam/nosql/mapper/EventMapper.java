package com.epam.nosql.mapper;

import com.epam.nosql.model.Event;
import com.epam.nosql.model.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Mapper
public interface EventMapper {

  EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

  @Mapping(target = "dateTime", ignore = true)
  EventDto eventToEventDto(Event event);

  @Mapping(target = "dateTime", ignore = true)
  Event eventDtoToEvent(EventDto event);
}
