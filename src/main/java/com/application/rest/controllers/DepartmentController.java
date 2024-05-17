package com.application.rest.controllers;

import com.application.rest.controllers.dto.DepartmentDTO;
import com.application.rest.models.Department;
import com.application.rest.services.DepartmentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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

        return ResponseEntity.ok(departments);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();

            DepartmentDTO departmentDTO = DepartmentDTO.builder()
                    .id(department.getId())
                    .name(department.getName())
                    .description(department.getDescription())
                    .build();

            return ResponseEntity.ok(departmentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {

        if (departmentDTO.getName().isBlank() || departmentDTO.getDescription().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        Department department = Department.builder()
                .name(departmentDTO.getName())
                .description(departmentDTO.getDescription())
                .build();

        departmentService.saveDepartment(department);

        return ResponseEntity.created(new URI("/api/v1/departments/save/" + department.getId())).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setName(departmentDTO.getName());
            department.setDescription(departmentDTO.getDescription());
            departmentService.updateDepartment(department);
            return ResponseEntity.ok("Updated success");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id) {
        Optional<Department> departmentOptional = departmentService.findDepartmentById(id);

        if (departmentOptional.isPresent()) {
            departmentService.deleteDepartment(id);
            return ResponseEntity.ok("Deleted success");
        }
        return ResponseEntity.notFound().build();
    }
}
