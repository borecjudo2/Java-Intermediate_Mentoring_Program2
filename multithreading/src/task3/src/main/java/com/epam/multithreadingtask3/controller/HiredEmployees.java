package com.epam.multithreadingtask3.controller;

import com.epam.multithreadingtask3.model.entity.Employee;
import com.epam.multithreadingtask3.service.EmployeesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@AllArgsConstructor
@RestController
@RequestMapping("/employees/hired")
public class HiredEmployees {

  private final EmployeesService employeesService;

  @GetMapping
  public List<Employee> getHiredEmployees() {
    return employeesService.getHiredEmployees();
  }
}
