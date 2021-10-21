package com.epam.task2.service.impl;

import com.epam.task2.model.SubTask;
import com.epam.task2.repo.SubTaskRepo;
import com.epam.task2.service.SubTaskService;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@AllArgsConstructor
public class SubTaskServiceImpl implements SubTaskService {

  private final SubTaskRepo repo;

  @Override
  public List<SubTask> findAllByName(String name) {
    return repo.findAllByName(name);
  }

  @Override
  public List<SubTask> findAllByCategory(String category) {
    return repo.findAllByCategory(category);
  }

  @Override
  public SubTask save(SubTask subTask) {
    return repo.save(subTask);
  }

  @Override
  public SubTask update(SubTask subTask) {
    return repo.save(subTask);
  }

  @Override
  public void delete(SubTask subTask) {
    repo.delete(subTask);
  }
}
