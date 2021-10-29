package com.epam.elkspringboot.service;

import com.epam.elkspringboot.model.Event;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface EventService {

  Event createEvent(Event event);

  List<Event> findAllEvents();

  List<Event> findAllByTitle(String title);

  List<Event> findAllEventWhereTypeWorkshopByTitle(String title);

  List<Event> findAllByDateTimeBeforeAndTitle(String dateTime, String title);

  void deleteAll();
}
