package com.epam.nosql.migration;

import com.epam.nosql.model.Event;
import com.epam.nosql.repo.EventRepository;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;

import java.util.Date;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@ChangeLog(order = "001")
public class MigrationJob {

  @ChangeSet(order = "001", id = "init_event", author = "aek")
  public void initDepartments(EventRepository repository) {
    Event event = new Event();
    event.setTitle("Demo");
    event.setPlace("LA");
    event.setSpeaker("Vlad");
    event.setEventType("Java conf");
    event.setDateTime(new Date());

    repository.save(event);
  }

}
