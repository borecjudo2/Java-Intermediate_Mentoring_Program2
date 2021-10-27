package com.epam.elkspringboot.service.impl;

import com.epam.elkspringboot.model.Event;
import com.epam.elkspringboot.model.enums.EventType;
import com.epam.elkspringboot.repo.EventRepository;
import com.epam.elkspringboot.service.EventService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
  public Event createEvent(Event event) {
    return repository.save(event);
  }

  @Override
  public List<Event> findAllEvents() {
    List<Event> events = new ArrayList<>();
    repository.findAll().forEach(events::add);
    return events;
  }

  @Override
  public List<Event> findAllByTitle(String title) {
    return repository.findAllByTitle(title);
  }

  @Override
  public List<Event> findAllEventWhereTypeWorkshopByTitle(String title) {
    return repository.findAllByEventTypeAndTitle(EventType.WORKSHOP, title);
  }

  @SneakyThrows
  @Override
  public List<Event> findAllByDateTimeBeforeAndTitle(String dateTime, String title) {
    Date date = new SimpleDateFormat("dd.MM.yyyy").parse(dateTime);
    return repository.findAllByDateTimeBeforeAndTitle(date, title);
  }

  @Override
  public void deleteAll() {
    repository.deleteAll();
  }
}
