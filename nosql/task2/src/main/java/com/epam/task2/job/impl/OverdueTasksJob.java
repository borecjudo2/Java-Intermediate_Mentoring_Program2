package com.epam.task2.job.impl;

import com.epam.task2.job.TaskJob;
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
public class OverdueTasksJob extends TaskJob {

  public OverdueTasksJob(TaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.OVERDUE_TASKS;
  }

  @Override
  public void update(BufferedReader reader) {
    System.out.println(getService().findAllOverdue(LocalDateTime.now()));
  }
}
