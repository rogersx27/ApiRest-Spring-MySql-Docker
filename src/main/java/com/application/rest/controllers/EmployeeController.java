package com.application.rest.controllers;

import com.application.rest.controllers.dto.EmployeeDTO;
import com.application.rest.models.Department;
import com.application.rest.models.Employee;
import com.application.rest.models.Position;
import com.application.rest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllEmployees() {
        List<EmployeeDTO> employees = employeeService.findAllEmployees()
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .email(employee.getEmail())
                        .phoneNumber(employee.getPhoneNumber())
                        .hireDate(employee.getHireDate())
                        .positionId(employee.getPosition().getId())
                        .departmentId(employee.getDepartment().getId())
                        .build())
                .toList();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .email(employee.getEmail())
                    .phoneNumber(employee.getPhoneNumber())
                    .hireDate(employee.getHireDate())
                    .positionId(employee.getPosition().getId())
                    .departmentId(employee.getDepartment().getId())
                    .employeeHasBenefits(employee.getEmployeeHasBenefits())
                    .build();

            return ResponseEntity.ok(employeeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeByEmail(email);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .email(employee.getEmail())
                    .phoneNumber(employee.getPhoneNumber())
                    .hireDate(employee.getHireDate())
                    .positionId(employee.getPosition().getId())
                    .departmentId(employee.getDepartment().getId())
                    .employeeHasBenefits(employee.getEmployeeHasBenefits())
                    .build();

            return ResponseEntity.ok(employeeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find/phone/{phoneNumber}")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeByPhoneNumber(phoneNumber);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .email(employee.getEmail())
                    .phoneNumber(employee.getPhoneNumber())
                    .hireDate(employee.getHireDate())
                    .positionId(employee.getPosition().getId())
                    .departmentId(employee.getDepartment().getId())
                    .employeeHasBenefits(employee.getEmployeeHasBenefits())
                    .build();

            return ResponseEntity.ok(employeeDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/hiredate/{hireDate}")
    public ResponseEntity<?> findByHireDate(@PathVariable LocalDate hireDate) {
        List<EmployeeDTO> employees = employeeService.findEmployeeByHireDate(hireDate)
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .email(employee.getEmail())
                        .phoneNumber(employee.getPhoneNumber())
                        .hireDate(employee.getHireDate())
                        .positionId(employee.getPosition().getId())
                        .departmentId(employee.getDepartment().getId())
                        .employeeHasBenefits(employee.getEmployeeHasBenefits())
                        .build())
                .toList();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/position/{positionId}")
    public ResponseEntity<?> findByPosition(@PathVariable Long positionId) {
        Position position = new Position();
        position.setId(positionId);

        List<EmployeeDTO> employees = employeeService.findEmployeesByPosition(position)
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .firstName(employee.getFirstName())
                        .lastName(employee.getLastName())
                        .email(employee.getEmail())
                        .phoneNumber(employee.getPhoneNumber())
                        .hireDate(employee.getHireDate())
                        .positionId(employee.getPosition().getId())
                        .departmentId(employee.getDepartment().getId())
                        .build())
                .toList();

        return ResponseEntity.ok(employees);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {

        if (employeeDTO.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        Position position = new Position();
        position.setId(employeeDTO.getPositionId());

        Department department = new Department();
        department.setId(employeeDTO.getDepartmentId());

        Employee employee = Employee.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .phoneNumber(employeeDTO.getPhoneNumber())
                .hireDate(employeeDTO.getHireDate())
                .position(position)
                .department(department)
                .build();

        employeeService.saveEmployee(employee);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

        System.out.println("employeeOptional: " + employeeOptional);

        if (employeeOptional.isPresent()) {

            System.out.println("employeeOptional is present");

            Employee employee = employeeOptional.get();
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setPhoneNumber(employeeDTO.getPhoneNumber());
            employeeService.updateEmployee(employee);
            return ResponseEntity.ok("Employee has updated successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
