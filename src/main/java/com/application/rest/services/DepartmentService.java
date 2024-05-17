package com.application.rest.services;

import com.application.rest.models.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<Department> findDepartmentById(Long id);

    List<Department> findAllDepartments();

    void saveDepartment(Department department);

    void deleteDepartment(Long id);

    void updateDepartment(Department department);
}
