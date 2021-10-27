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
public class NameSubtasksJob extends SubTaskJob {

  public NameSubtasksJob(SubTaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.NAME_SUBTASKS;
  }

  @SneakyThrows
  @Override
  public void update(BufferedReader reader) {
    System.out.println("Print name");
    String name = reader.readLine();
    System.out.println(getService().findAllByName(name));
  }
}
