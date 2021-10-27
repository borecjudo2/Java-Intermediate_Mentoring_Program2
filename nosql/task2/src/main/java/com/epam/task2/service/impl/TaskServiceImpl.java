package com.epam.task2.service.impl;

import com.epam.task2.model.Task;
import com.epam.task2.repo.TaskRepo;
import com.epam.task2.service.TaskService;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepo repo;

  @Override
  public List<Task> findAll() {
    return repo.findAll();
  }

  @Override
  public List<Task> findAllOverdue(LocalDateTime date) {
    return repo.findAllOverdue(date);
  }

  @Override
  public List<Task> findAllByName(String name) {
    return repo.findAllByName(name);
  }

  @Override
  public List<Task> findAllByCategory(String category) {
    return repo.findAllByCategory(category);
  }

  @Override
  public Task save(Task task) {
    return repo.save(task);
  }

  @Override
  public Task update(Task task) {
    return repo.save(task);
  }

  @Override
  public void delete(Task task) {
    repo.delete(task);
  }
}
