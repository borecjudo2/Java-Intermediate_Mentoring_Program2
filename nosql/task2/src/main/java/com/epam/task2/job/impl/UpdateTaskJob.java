package com.epam.task2.job.impl;

import com.epam.task2.job.TaskJob;
import com.epam.task2.model.Task;
import com.epam.task2.model.enums.AppJob;
import com.epam.task2.service.TaskService;

import java.io.BufferedReader;
import java.time.LocalDateTime;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class UpdateTaskJob extends TaskJob {

  public UpdateTaskJob(TaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.UPDATE_TASK;
  }

  @Override
  public void update(BufferedReader reader) {
    System.out.println(getService().update(createTask()));
  }

  private static Task createTask() {
    return Task.builder()
        .name("Buhich")
        .category("Alco")
        .description("Bydem buhac")
        .dateOfCreation(LocalDateTime.now())
        .deadline(LocalDateTime.now())
        .build();
  }
}
