package com.epam.multithreadingtask3.model.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Data
@RequiredArgsConstructor
public class Employee {

  @NonNull
  private Integer id;

  @NonNull
  private String name;

  @NonNull
  private boolean hired;

  private Integer salary;

}
