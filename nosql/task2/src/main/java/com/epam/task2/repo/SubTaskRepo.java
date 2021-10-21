package com.epam.task2.repo;

import com.epam.task2.model.SubTask;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface SubTaskRepo {

    List<SubTask> findAllByName(String name);

    List<SubTask> findAllByCategory(String category);

    SubTask save(SubTask subTask);

    void delete(SubTask subTask);

}
