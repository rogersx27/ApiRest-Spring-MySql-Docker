package com.application.rest.services;

import com.application.rest.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findAllEmployees();
    void saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    void updateEmployee(Employee employee);
}
