package com.epam.task2.repo;

import com.epam.task2.model.Task;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface TaskRepo {

  List<Task> findAll();

  List<Task> findAllOverdue(LocalDateTime date);

  List<Task> findAllByName(String name);

  List<Task> findAllByCategory(String category);

  Task findById(String id);

  Task save(Task task);

  void delete(Task task);

}
