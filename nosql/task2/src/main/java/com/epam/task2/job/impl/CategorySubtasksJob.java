package com.epam.task2.job.impl;

import com.epam.task2.job.SubTaskJob;
import com.epam.task2.model.enums.AppJob;
import com.epam.task2.service.SubTaskService;
import lombok.SneakyThrows;

import java.io.BufferedReader;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class CategorySubtasksJob extends SubTaskJob {

  public CategorySubtasksJob(SubTaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.CATEGORY_SUBTASKS;
  }

  @SneakyThrows
  @Override
  public void update(BufferedReader reader) {
    System.out.println("Print category");
    String category = reader.readLine();
    System.out.println(getService().findAllByCategory(category));
  }
}
