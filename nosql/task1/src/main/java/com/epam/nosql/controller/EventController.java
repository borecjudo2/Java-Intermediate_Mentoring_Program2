package com.epam.nosql.controller;

import com.epam.nosql.exception.NotFoundEntityException;
import com.epam.nosql.mapper.EventMapper;
import com.epam.nosql.model.Event;
import com.epam.nosql.model.EventDto;
import com.epam.nosql.service.EventService;
import com.google.common.base.Strings;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@RestController
@RequestMapping("event")
@Validated
@AllArgsConstructor
public class EventController {

  private final EventService service;

  private final EventMapper mapper;

  @Operation(summary = "Get all events")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found all events",
          content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class)) }),
      @ApiResponse(responseCode = "204", description = "Not found events")})
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<EventDto> getAllEvent() {
    List<Event> allEvents = service.getAllEvents();
    if (allEvents.isEmpty()) {
      throw new NotFoundEntityException();
    }
    return allEvents.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  @Operation(summary = "Get a event by id")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found a event",
          content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class)) }),
      @ApiResponse(responseCode = "204", description = "Not found event")})
  @GetMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public EventDto getEventById(
      @NotBlank(message = "Id should be not null")
      @PathVariable("id") String id) {
    Event event = service.getEventById(id);
    return convertToDto(event);
  }

  @Operation(summary = "Get a event by title")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Found a event",
          content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class)) }),
      @ApiResponse(responseCode = "204", description = "Not found event")})
  @GetMapping("by")
  @ResponseStatus(HttpStatus.OK)
  public EventDto getEventByTitle(
      @NotBlank(message = "Title should be not null")
      @PathParam("title") String title) {
    Event event = service.getAllEventsByTitle(title);
    return convertToDto(event);
  }

  @Operation(summary = "Create a event")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Event is created",
          content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class)) })})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public EventDto createEvent(@Valid @RequestBody EventDto eventDto) {
    Event event = convertToEntity(eventDto);
    Event createdEvent = service.createEvent(event);
    return convertToDto(createdEvent);
  }

  @Operation(summary = "Update event")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Event is updated",
          content = {@Content(mediaType = "application/json", schema = @Schema(implementation = EventDto.class)) }),
      @ApiResponse(responseCode = "204", description = "Not found event")})
  @PutMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public EventDto updateEvent(
      @NotBlank(message = "Id should be not null")
      @PathVariable("id") String id,
      @Valid @RequestBody EventDto eventDto) {
    Event event = convertToEntity(eventDto);
    Event updatedEvent = service.updateEvent(id, event);
    return convertToDto(updatedEvent);
  }

  @Operation(summary = "Delete event")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Event is deleted"),
      @ApiResponse(responseCode = "204", description = "Not found event")})
  @DeleteMapping(value = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteEvent(
      @NotBlank(message = "Id should be not null")
      @PathVariable("id") String id) {
    Event event = service.getEventById(id);
    service.deleteEvent(event);
  }

  @SneakyThrows
  private Event convertToEntity(EventDto eventDto) {
    Event event = mapper.eventDtoToEvent(eventDto);
    if (!Strings.isNullOrEmpty(eventDto.getDateTime())) {
      event.setDateTime(new SimpleDateFormat("dd.MM.yyyy").parse(eventDto.getDateTime()));
    }
    return event;
  }

  private EventDto convertToDto(Event event) {
    EventDto eventDto = mapper.eventToEventDto(event);
    if (Objects.nonNull(event.getDateTime())) {
      eventDto.setDateTime(new SimpleDateFormat("dd.MM.yyyy").format(event.getDateTime()));
    }
    return eventDto;
  }

}
