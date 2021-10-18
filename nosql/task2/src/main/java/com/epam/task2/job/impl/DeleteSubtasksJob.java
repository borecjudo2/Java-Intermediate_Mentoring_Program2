package com.epam.task2.job.impl;

import com.epam.task2.job.SubTaskJob;
import com.epam.task2.model.SubTask;
import com.epam.task2.model.enums.AppJob;
import com.epam.task2.service.SubTaskService;

import java.io.BufferedReader;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class DeleteSubtasksJob extends SubTaskJob {

  public DeleteSubtasksJob(SubTaskService service) {
    super(service);
  }

  @Override
  public AppJob getAppJob() {
    return AppJob.DELETE_SUBTASK;
  }

  @Override
  public void update(BufferedReader reader) {
    getService().delete(createSubTask());
  }

  private SubTask createSubTask() {
    return SubTask.builder()
        .name("Java API")
        .description("Update API")
        .build();
  }
}
