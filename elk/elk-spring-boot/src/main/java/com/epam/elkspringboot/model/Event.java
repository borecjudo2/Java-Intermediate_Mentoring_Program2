package com.epam.elkspringboot.model;

import com.epam.elkspringboot.model.enums.EventType;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Data
@Document(indexName = "events")
public class Event {

  @Id
  private String id;

  @NonNull
  @Field(name = "title", type = FieldType.Text)
  private String title;

  @NonNull
  private EventType eventType;

  @NonNull
  private Date dateTime;

  @NonNull
  private String place;

  private List<String> subtopics;

}
