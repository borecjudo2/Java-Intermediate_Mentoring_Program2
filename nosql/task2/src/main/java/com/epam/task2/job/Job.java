package com.epam.task2.job;

import com.epam.task2.model.enums.AppJob;

import java.io.BufferedReader;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public abstract class Job {

  public boolean isMe(String id) {
    return getAppJob().getId().equals(id);
  }

  public abstract AppJob getAppJob();

  public abstract void update(BufferedReader reader);

}
