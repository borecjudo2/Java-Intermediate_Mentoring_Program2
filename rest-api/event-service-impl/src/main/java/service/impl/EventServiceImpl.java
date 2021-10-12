package service.impl;

import exception.NotFoundEntityException;
import model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repo.EventRepository;
import service.EventService;

import java.util.List;
import javax.transaction.Transactional;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Service
public class EventServiceImpl implements EventService {

  @Autowired
  private EventRepository repository;

  @Override
  @Transactional
  public List<Event> getAllEvents() {
    return (List<Event>) repository.findAll();
  }

  @Override
  public Event getEventById(Integer id) {
    return repository.findById(id).orElseThrow(NotFoundEntityException::new);
  }

  @Override
  @Transactional
  public Event getAllEventsByTitle(String title) {
    return repository.findEventByTitle(title).orElseThrow(NotFoundEntityException::new);
  }

  @Override
  @Transactional
  public Event createEvent(Event event) {
    return repository.save(event);
  }

  @Override
  @Transactional
  public Event updateEvent(Integer id, Event event) {
    Event existingEvent = getEventById(id);
    Event updatedEvent = updateEvent(existingEvent, event);
    return repository.save(updatedEvent);
  }

  private Event updateEvent(Event existingEvent, Event newEvent) {
    newEvent.setId(existingEvent.getId());
    return newEvent;
  }

  @Override
  @Transactional
  public void deleteEvent(Event event) {
    repository.delete(event);
  }

}
