package com.epam.task2.job.impl;

import com.epam.task2.job.TaskJob;
import com.epam.task2.model.enums.AppJob;
import com.epam.task2.service.TaskService;
import lombok.SneakyThrows;

import java.io.BufferedReader;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class CategoryTasksJob extends TaskJob {

  public CategoryTasksJob(TaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.CATEGORY_TASKS;
  }

  @SneakyThrows
  @Override
  public void update(BufferedReader reader) {
    System.out.println("Print category");
    String category = reader.readLine();
    System.out.println(getService().findAllByCategory(category));
  }
}
