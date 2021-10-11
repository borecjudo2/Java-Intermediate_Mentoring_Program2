package com.epam.multithreadingtask3.service.impl;

import com.epam.multithreadingtask3.model.entity.Employee;
import com.epam.multithreadingtask3.repo.EmployeesRepository;
import com.epam.multithreadingtask3.service.EmployeesService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * DESCRIPTION
 *
 * @author Vladislav_Karpeka
 * @version 1.0.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

  private final EmployeesRepository employeesRepository;

  @SneakyThrows
  @Override
  public List<Employee> getHiredEmployees() {
    return CompletableFuture.supplyAsync(employeesRepository::getHiredEmployee)
        .thenApply(employeesRepository::getSalary)
        .thenApply(this::logEmployees)
        .get();
  }

  private List<Employee> logEmployees(List<Employee> employees) {
    log.info(String.valueOf(employees));
    return employees;
  }
}
