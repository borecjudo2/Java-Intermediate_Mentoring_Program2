package com.epam.nosql.service.impl;

import com.epam.nosql.exception.NotFoundEntityException;
import com.epam.nosql.model.Event;
import com.epam.nosql.repo.EventRepository;
import com.epam.nosql.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository repository;

  @Override
  public List<Event> getAllEvents() {
    return repository.findAll();
  }

  @Override
  public Event getEventById(String id) {
    return repository.findById(id).orElseThrow(NotFoundEntityException::new);
  }

  @Override
  public Event getAllEventsByTitle(String title) {
    return repository.findEventByTitle(title).orElseThrow(NotFoundEntityException::new);
  }

  @Override
  public Event createEvent(Event event) {
    return repository.save(event);
  }

  @Override
  public Event updateEvent(String id, Event event) {
    Event existingEvent = getEventById(id);
    Event updatedEvent = updateEvent(existingEvent, event);
    return repository.save(updatedEvent);
  }

  private Event updateEvent(Event existingEvent, Event newEvent) {
    newEvent.setId(existingEvent.getId());
    return newEvent;
  }

  @Override
  public void deleteEvent(Event event) {
    repository.delete(event);
  }

}
