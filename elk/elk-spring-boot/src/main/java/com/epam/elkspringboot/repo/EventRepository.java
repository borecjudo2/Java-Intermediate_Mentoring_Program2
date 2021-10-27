package com.epam.elkspringboot.repo;

import com.epam.elkspringboot.model.Event;
import com.epam.elkspringboot.model.enums.EventType;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Date;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface EventRepository extends ElasticsearchRepository<Event, String> {

  List<Event> findAllByEventTypeAndTitle(EventType eventType, String title);

  List<Event> findAllByTitle(String title);

  List<Event> findAllByDateTimeBeforeAndTitle(Date dateTime, String title);
}
