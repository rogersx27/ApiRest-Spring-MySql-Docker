package com.application.rest.persistence.implementations;

import com.application.rest.models.Employee;
import com.application.rest.models.Position;
import com.application.rest.persistence.EmployeeDAO;
import com.application.rest.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;

@Component
public class EmployeeDAOImplement implements EmployeeDAO {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeByEmail(String email) {
        return employeeRepository.findEmployeeByEmail(email);
    }

    @Override
    public Optional<Employee> findEmployeeByPhoneNumber(String phoneNumber) {
        return employeeRepository.findEmployeeByPhoneNumber(phoneNumber);
    }

    @Override
    public Collection<Employee> findEmployeeByHireDate(LocalDate hireDate) {

        return employeeRepository.findEmployeeByHireDate(hireDate);
    }

    @Override
    public List<Employee> findByPosition(Position position) {
        return employeeRepository.findByPosition(position);
    }


}
