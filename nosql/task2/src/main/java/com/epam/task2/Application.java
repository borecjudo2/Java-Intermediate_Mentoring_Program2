package com.epam.task2;

import com.epam.task2.config.Config;
import com.epam.task2.job.Job;
import com.epam.task2.model.enums.AppJob;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public class Application extends Config {

  @SneakyThrows
  public static void main(String[] args) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      AppJob.printAll();
      String job = reader.readLine();
      for (Job allJob : getAllJobs()) {
        if (allJob.isMe(job)) {
          allJob.update(reader);
          break;
        }
      }
    }

  }

}
