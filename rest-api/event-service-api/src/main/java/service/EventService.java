package service;

import model.Event;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface EventService {

  List<Event> getAllEvents();
  Event getEventById(Integer id);
  Event getAllEventsByTitle(String title);

  Event createEvent(Event event);
  Event updateEvent(Integer id, Event event);

  void deleteEvent(Event event);

}
