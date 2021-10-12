package model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String title;

  private String place;

  private String speaker;

  private String eventType;

  private Date dateTime;

}
