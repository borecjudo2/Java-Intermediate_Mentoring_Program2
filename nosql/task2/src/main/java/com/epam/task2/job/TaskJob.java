package com.epam.task2.job;

import com.epam.task2.service.TaskService;
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
public abstract class TaskJob extends Job {

  private final TaskService service;
}
