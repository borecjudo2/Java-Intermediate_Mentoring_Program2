package com.epam.restapi.controller;

import com.epam.restapi.exception.NotFoundEntityException;
import com.epam.restapi.model.Event;
import com.epam.restapi.model.EventDto;
import com.epam.restapi.service.EventService;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.websocket.server.PathParam;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@RestController
@RequestMapping("event")
@AllArgsConstructor
public class EventController {

  private final EventService service;

  private final ModelMapper mapper;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<EventDto> getAllEvent() {
    List<Event> allEvents = service.getAllEvents();
    if (allEvents.isEmpty()) {
      throw new NotFoundEntityException();
    }
    return allEvents.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  @GetMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public EventDto getEventById(@PathVariable("id") Integer id) {
    Event event = service.getEventById(id);
    return convertToDto(event);
  }

  @GetMapping("by")
  @ResponseStatus(HttpStatus.OK)
  public EventDto getEventByTitle(@PathParam("title") String title) {
    Event event = service.getAllEventsByTitle(title);
    return convertToDto(event);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public EventDto createEvent(@RequestBody EventDto eventDto) {
    Event event = convertToEntity(eventDto);
    Event createdEvent = service.createEvent(event);
    return convertToDto(createdEvent);
  }

  @PutMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public EventDto updateEvent(@PathVariable("id") Integer id, @RequestBody EventDto eventDto) {
    Event event = convertToEntity(eventDto);
    Event updatedEvent = service.updateEvent(id, event);
    return convertToDto(updatedEvent);
  }

  @DeleteMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteEvent(@PathVariable("id") Integer id) {
    Event event = service.getEventById(id);
    service.deleteEvent(event);
  }

  @SneakyThrows
  private Event convertToEntity(EventDto eventDto) {
    Event event = mapper.map(eventDto, Event.class);
    if (!Strings.isNullOrEmpty(eventDto.getDateTime())) {
      event.setDateTime(new SimpleDateFormat("dd.MM.yyyy").parse(eventDto.getDateTime()));
    }
    return event;
  }

  private EventDto convertToDto(Event event) {
    EventDto eventDto = mapper.map(event, EventDto.class);
    if (Objects.nonNull(event.getDateTime())) {
      eventDto.setDateTime(new SimpleDateFormat("dd.MM.yyyy").format(event.getDateTime()));
    }
    return eventDto;
  }

}
