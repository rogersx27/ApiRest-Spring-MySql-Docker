package com.application.rest.persistence;

import com.application.rest.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findAllEmployees();
    void saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    void updateEmployee(Employee employee);
}
