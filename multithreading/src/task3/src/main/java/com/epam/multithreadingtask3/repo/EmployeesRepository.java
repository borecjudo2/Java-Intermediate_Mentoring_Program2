package com.epam.multithreadingtask3.repo;

import com.epam.multithreadingtask3.model.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Component
public class EmployeesRepository {

  public List<Employee> getHiredEmployee() {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee(1, "Vlad", true));
    employees.add(new Employee(2, "Oleg", true));
    employees.add(new Employee(3, "Ilya", true));
    return employees;
  }

  public List<Employee> getSalary(List<Employee> employees) {
    Random random = new Random();
    employees.forEach(employee -> employee.setSalary(random.nextInt()));
    return employees;
  }
}
