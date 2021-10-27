package com.epam.task2.config;

import com.epam.task2.job.Job;
import com.epam.task2.job.impl.AllTasksJob;
import com.epam.task2.job.impl.CategorySubtasksJob;
import com.epam.task2.job.impl.CategoryTasksJob;
import com.epam.task2.job.impl.CreateSubtasksJob;
import com.epam.task2.job.impl.CreateTaskJob;
import com.epam.task2.job.impl.DeleteSubtasksJob;
import com.epam.task2.job.impl.DeleteTaskJob;
import com.epam.task2.job.impl.NameSubtasksJob;
import com.epam.task2.job.impl.NameTasksJob;
import com.epam.task2.job.impl.OverdueTasksJob;
import com.epam.task2.job.impl.UpdateSubtasksJob;
import com.epam.task2.job.impl.UpdateTaskJob;
import com.epam.task2.repo.SubTaskRepo;
import com.epam.task2.repo.TaskRepo;
import com.epam.task2.repo.impl.SubTaskRepoImpl;
import com.epam.task2.repo.impl.TaskRepoImpl;
import com.epam.task2.service.SubTaskService;
import com.epam.task2.service.TaskService;
import com.epam.task2.service.impl.SubTaskServiceImpl;
import com.epam.task2.service.impl.TaskServiceImpl;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class Config {

  private static final TaskRepo taskRepo = new TaskRepoImpl();
  private static final SubTaskRepo subTaskRepo = new SubTaskRepoImpl();

  @Getter
  private static final TaskService taskService = new TaskServiceImpl(taskRepo);

  @Getter
  private static final SubTaskService subTaskService = new SubTaskServiceImpl(subTaskRepo);

  protected static List<Job> getAllJobs() {
    List<Job> jobs = new ArrayList<>();
    jobs.add(new AllTasksJob(taskService));
    jobs.add(new OverdueTasksJob(taskService));
    jobs.add(new NameTasksJob(taskService));
    jobs.add(new CategoryTasksJob(taskService));
    jobs.add(new CreateTaskJob(taskService));
    jobs.add(new UpdateTaskJob(taskService));
    jobs.add(new DeleteTaskJob(taskService));
    jobs.add(new CategorySubtasksJob(subTaskService));
    jobs.add(new NameSubtasksJob(subTaskService));
    jobs.add(new CreateSubtasksJob(subTaskService));
    jobs.add(new UpdateSubtasksJob(subTaskService));
    jobs.add(new DeleteSubtasksJob(subTaskService));
    return jobs;
  }

}
