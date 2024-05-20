package com.application.rest.controllers;

import com.application.rest.controllers.dto.DepartmentDTO;
import com.application.rest.models.Department;
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
import java.util.List;
import java.util.Optional;

@Log
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllDepartments() {
        List<DepartmentDTO> departments = departmentService.findAllDepartments()
                .stream()
                .map(department -> DepartmentDTO.builder()
                        .id(department.getId())
                        .description(department.getDescription())
                        .name(department.getName())
                        .build())
                .toList();

        log.info("All departments found");
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (!departmentOptional.isPresent()) {
            log.warning("Department with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        Department department = departmentOptional.get();

        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .build();

        log.info("Department with id " + id + " found");
        return ResponseEntity.ok(departmentDTO);
    }

    @PostMapping("/save")
    @SneakyThrows(value = {URISyntaxException.class, IllegalArgumentException.class})
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {

        departmentDTO.isValid();

        Department department = Department.builder()
                .name(departmentDTO.getName())
                .description(departmentDTO.getDescription())
                .build();

        departmentService.saveDepartment(department);

        log.info("Department saved");
        return ResponseEntity.created(new URI("/api/v1/departments/find/" + department.getId())).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (!departmentOptional.isPresent()) {
            log.warning("Department with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        Department department = departmentOptional.get();
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        departmentService.updateDepartment(department);

        log.info("Department: " + department.getId() + " updated");
        return ResponseEntity.ok("Updated success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (!departmentOptional.isPresent()) {
            log.warning("Department with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        departmentService.deleteDepartment(id);

        log.info("Department with id " + id + " deleted");
        return ResponseEntity.ok("Deleted success");
    }
}
