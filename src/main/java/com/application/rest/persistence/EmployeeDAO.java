package com.application.rest.persistence;

import com.application.rest.models.Employee;
import com.application.rest.models.Position;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findAllEmployees();
    void saveEmployee(Employee employee);

    void deleteEmployee(Long id);

    void updateEmployee(Employee employee);

    Optional<Employee> findEmployeeByEmail(String email);

    Optional<Employee> findEmployeeByPhoneNumber(String phoneNumber);

    Collection<Employee> findEmployeeByHireDate(LocalDate hireDate);

    List<Employee> findByPosition(Position position);
}
