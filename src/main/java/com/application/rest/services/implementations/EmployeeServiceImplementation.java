package com.application.rest.services.implementations;

import com.application.rest.models.Employee;
import com.application.rest.models.Position;
import com.application.rest.persistence.EmployeeDAO;
import com.application.rest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeDAO.findEmployeeById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public Optional<Employee> findEmployeeByEmail(String email) {
        return employeeDAO.findEmployeeByEmail(email);
    }

    @Override
    public Optional<Employee> findEmployeeByPhoneNumber(String phoneNumber) {
        return employeeDAO.findEmployeeByPhoneNumber(phoneNumber);
    }

    @Override
    public Collection<Employee> findEmployeeByHireDate(LocalDate hireDate) {
        return employeeDAO.findEmployeeByHireDate(hireDate);
    }

    @Override
    public List<Employee> findEmployeesByPosition(Position position) {
        return employeeDAO.findByPosition(position);
    }


}
