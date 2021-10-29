package com.epam.elkspringboot.controller;

import com.epam.elkspringboot.model.Event;
import com.epam.elkspringboot.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */

@RestController
@RequestMapping("/events")
@AllArgsConstructor
public class EventController {

  private final EventService service;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Event createEvent(@RequestBody Event event) {
    return service.createEvent(event);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Event> findAllEvents() {
    return service.findAllEvents();
  }

  @GetMapping("/{title}")
  @ResponseStatus(HttpStatus.OK)
  public List<Event> findAllByTitle(@PathVariable("title") String title) {
    return service.findAllByTitle(title);
  }

  @GetMapping("/{title}/workshop")
  @ResponseStatus(HttpStatus.OK)
  public List<Event> findAllEventWhereTypeWorkshopByTitle(@PathVariable("title") String title) {
    return service.findAllEventWhereTypeWorkshopByTitle(title);
  }

  @GetMapping("/{beforeDateTime}/{title}")
  @ResponseStatus(HttpStatus.OK)
  public List<Event> findAllByDateTimeBeforeAndTitle(@PathVariable("beforeDateTime") String beforeDateTime,
      @PathVariable("title") String title) {
    return service.findAllByDateTimeBeforeAndTitle(beforeDateTime, title);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAll() {
    service.deleteAll();
  }

}
