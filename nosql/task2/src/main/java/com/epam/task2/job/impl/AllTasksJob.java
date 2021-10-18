package com.epam.task2.job.impl;

import com.epam.task2.job.TaskJob;
import com.epam.task2.model.enums.AppJob;
import com.epam.task2.service.TaskService;

import java.io.BufferedReader;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class AllTasksJob extends TaskJob {

  public AllTasksJob(TaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.All_TASKS;
  }

  @Override
  public void update(BufferedReader reader) {
    System.out.println(getService().findAll());
  }
}
