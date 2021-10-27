package com.epam.task2.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum AppJob {

  All_TASKS("1", "Display on console all tasks"),
  OVERDUE_TASKS("2", "Display overdue tasks"),
  NAME_TASKS("3", "Display tasks by name"),
  CATEGORY_TASKS("4", "Display all tasks with the specific category"),

  CREATE_TASK("5", "Create task"),
  UPDATE_TASK("6", "Update task"),
  DELETE_TASK("7", "Delete task"),

  CATEGORY_SUBTASKS("8", "Display all subtasks related to tasks with the specific category"),
  NAME_SUBTASKS("9", "Display subtasks by name"),

  CREATE_SUBTASK("10", "Create subtask"),
  UPDATE_SUBTASK("11", "Update subtask"),
  DELETE_SUBTASK("12", "Delete subtask");

  private final String id;
  private final String description;

  @Override
  public String toString() {
    return id + ") " + description;
  }

  public static void printAll() {
    for (AppJob value : AppJob.values()) {
      System.out.println(value);
    }
  }
}
