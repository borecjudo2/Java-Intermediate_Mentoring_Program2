package com.epam.task2.repo.impl;

import com.epam.task2.model.Task;
import com.epam.task2.repo.MongoRepo;
import com.epam.task2.repo.TaskRepo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class TaskRepoImpl extends MongoRepo implements TaskRepo {

  public TaskRepoImpl() {
    super();
  }

  @Override
  public List<Task> findAll() {
    return datastore.createQuery(Task.class)
        .find()
        .toList();
  }

  @Override
  public List<Task> findAllOverdue(LocalDateTime date) {
    return datastore.createQuery(Task.class)
        .field("deadline")
        .lessThan(date)
        .find()
        .toList();
  }

  @Override
  public List<Task> findAllByName(String name) {
    return datastore.createQuery(Task.class)
        .field("name")
        .containsIgnoreCase(name)
        .find()
        .toList();
  }

  @Override
  public List<Task> findAllByCategory(String category) {
    return datastore.createQuery(Task.class)
        .field("category")
        .containsIgnoreCase(category)
        .find()
        .toList();
  }

  @Override
  public Task findById(String id) {
    return datastore.createQuery(Task.class)
        .field("id")
        .containsIgnoreCase(id)
        .find()
        .tryNext();
  }

  @Override
  public Task save(Task task) {
    return datastore.save(task);
  }

  @Override
  public void delete(Task task) {
    datastore.delete(task);
  }
}
