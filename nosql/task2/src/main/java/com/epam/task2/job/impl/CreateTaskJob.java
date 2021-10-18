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
public class CreateTaskJob extends TaskJob {

  public CreateTaskJob(TaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.CREATE_TASK;
  }

  @Override
  public void update(BufferedReader reader) {
    Task task = createTask();
    System.out.println(getService().save(task));
  }

  private Task createTask() {
    return Task.builder()
        .name("Demo for customer")
        .category("demo")
        .description("Main demo for dev and customer for previous PI")
        .dateOfCreation(LocalDateTime.now())
        .deadline(LocalDateTime.now())
        .build();
  }
}
