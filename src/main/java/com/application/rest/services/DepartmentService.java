package com.application.rest.services;

import com.application.rest.models.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Optional<Department> findDepartmentById(Long id);

    List<Department> findAllDepartments();

    void saveDeparment(Department department);

    void deleteDeparment(Long id);

    void updateDeparment(Department department);
}
