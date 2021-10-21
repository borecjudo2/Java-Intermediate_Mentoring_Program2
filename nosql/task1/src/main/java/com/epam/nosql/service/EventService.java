package com.epam.nosql.service;

import com.epam.nosql.model.Event;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface EventService {

  List<Event> getAllEvents();
  Event getEventById(String id);
  Event getAllEventsByTitle(String title);

  Event createEvent(Event event);
  Event updateEvent(String id, Event event);

  void deleteEvent(Event event);

}
