package com.epam.multithreadingtask3.service;

import com.epam.multithreadingtask3.model.entity.Employee;

import java.util.List;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
public interface EmployeesService {

  List<Employee> getHiredEmployees();
}
