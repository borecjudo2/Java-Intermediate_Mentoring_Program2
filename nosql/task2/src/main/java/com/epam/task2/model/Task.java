package com.epam.task2.model;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
@Entity("tasks")
public class Task {

  @Id
  private String id;

  private String name;

  private String description;

  private LocalDateTime dateOfCreation;

  private LocalDateTime deadline;

  private String category;

  @Reference
  private List<SubTask> subtasks;

}
