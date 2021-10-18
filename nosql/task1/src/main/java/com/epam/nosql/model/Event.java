package com.epam.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Getter
@Setter
@Document
public class Event {

  @Id
  private String id;

  private String title;

  private String place;

  private String speaker;

  private String eventType;

  private Date dateTime;

}
