package com.application.rest.persistence;

import com.application.rest.models.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentDAO {

    Optional<Department> findDepartmentById(Long id);

    List<Department> findAllDepartments();

    void saveDepartment(Department department);

    void deleteDepartment(Long id);

    void updateDepartment(Department department);
}
