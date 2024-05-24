package com.application.rest.controllers;

import com.application.rest.controllers.dto.EmployeeDTO;
import com.application.rest.models.Department;
import com.application.rest.models.Employee;
import com.application.rest.models.Position;
import com.application.rest.services.DepartmentService;
import com.application.rest.services.EmployeeService;
import com.application.rest.services.PositionService;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Log
@CrossOrigin
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private DepartmentService departmentService;

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

        log.info("All employees found");
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

        if (!employeeOptional.isPresent()) {
            log.warning("Employee with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

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

        log.info("Employee with id " + id + " found");
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/find/email/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeByEmail(email);

        if (!employeeOptional.isPresent()) {
            log.warning("Employee with email " + email + " not found");
            return ResponseEntity.notFound().build();
        }

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

        log.info("Employee with email " + email + " found");
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/find/phone/{phoneNumber}")
    public ResponseEntity<?> findByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeByPhoneNumber(phoneNumber);

        if (!employeeOptional.isPresent()) {
            log.warning("Employee with phone number " + phoneNumber + " not found");
            return ResponseEntity.notFound().build();
        }

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

        log.info("Employee with phone number " + phoneNumber + " found");
        return ResponseEntity.ok(employeeDTO);
    }

    @GetMapping("/find/hiredate/{hireDate}")
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

        log.info("Employees with hire date " + hireDate + " found");
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/find/position/{positionId}")
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

        log.info("Employees with position id " + positionId + " and position name " + position.getTitle() + " found");
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/save")
    @SneakyThrows(value = {URISyntaxException.class, IllegalArgumentException.class})
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) throws URISyntaxException {

        employeeDTO.isValid();

        //Position position = new Position();
        //position.setId(employeeDTO.getPositionId());

        log.info("First Name: " + employeeDTO.getFirstName());
        log.info("Position ID: " + employeeDTO.getPositionId());
        log.info("Department ID: " + employeeDTO.getDepartmentId());

        Position position = positionService.findPositionById(employeeDTO.getPositionId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Position ID"));

        log.info("Position found" + position.getTitle());

        //Department department = new Department();
        //department.setId(employeeDTO.getDepartmentId());

        Department department = departmentService.findDepartmentById(employeeDTO.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Department ID"));

        log.info("Department found" + department.getName());

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

        log.info("Employee saved");
        return ResponseEntity.created(new URI("/api/v1/employees/find/" + employee.getId())).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

        if (!employeeOptional.isPresent()) {
            log.warning("Employee with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        Employee employee = employeeOptional.get();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employeeService.updateEmployee(employee);

        log.info("Employee with id " + id + " updated");
        return ResponseEntity.ok("Updated success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Optional<Employee> employeeOptional = employeeService.findEmployeeById(id);

        if (!employeeOptional.isPresent()) {
            log.warning("Employee with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        employeeService.deleteEmployee(id);

        log.info("Employee with id " + id + " deleted");
        return ResponseEntity.ok("Deleted success");
    }
}
