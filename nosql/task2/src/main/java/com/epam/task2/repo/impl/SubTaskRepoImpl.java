package com.epam.task2.repo.impl;

import com.epam.task2.model.SubTask;
import com.epam.task2.repo.MongoRepo;
import com.epam.task2.repo.SubTaskRepo;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class SubTaskRepoImpl extends MongoRepo implements SubTaskRepo {

  public SubTaskRepoImpl() {
    super();
  }

  @Override
  public List<SubTask> findAllByName(String name) {
    return datastore.createQuery(SubTask.class)
        .field("name)")
        .containsIgnoreCase(name)
        .find()
        .toList();
  }

  @Override
  public List<SubTask> findAllByCategory(String category) {
    return datastore.createQuery(SubTask.class)
        .field("category")
        .containsIgnoreCase(category)
        .find()
        .toList();
  }

  @Override
  public SubTask save(SubTask subTask) {
    return datastore.save(subTask);
  }

  @Override
  public void delete(SubTask subTask) {
    datastore.delete(subTask);
  }
}
