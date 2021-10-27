package com.epam.elkspringboot.service.impl;

import com.epam.elkspringboot.model.Event;
import com.epam.elkspringboot.model.enums.EventType;
import com.epam.elkspringboot.repo.EventRepository;
import com.epam.elkspringboot.service.EventService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

  private final EventRepository repository;

  @Override
  public Event createEvent(Event event) {
    log.info("createEvent");
    return repository.save(event);
  }

  @Override
  public List<Event> findAllEvents() {
    log.info("findAllEvents");
    List<Event> events = new ArrayList<>();
    repository.findAll().forEach(events::add);
    return events;
  }

  @Override
  public List<Event> findAllByTitle(String title) {
    log.info("findAllByTitle");
    return repository.findAllByTitle(title);
  }

  @Override
  public List<Event> findAllEventWhereTypeWorkshopByTitle(String title) {
    log.info("findAllEventWhereTypeWorkshopByTitle");
    return repository.findAllByEventTypeAndTitle(EventType.WORKSHOP, title);
  }

  @SneakyThrows
  @Override
  public List<Event> findAllByDateTimeBeforeAndTitle(String dateTime, String title) {
    log.info("findAllByDateTimeBeforeAndTitle");
    Date date = new SimpleDateFormat("dd.MM.yyyy").parse(dateTime);
    return repository.findAllByDateTimeBeforeAndTitle(date, title);
  }

  @Override
  public void deleteAll() {
    log.info("deleteAll");
    repository.deleteAll();
  }
}
