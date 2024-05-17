package com.application.rest.services.implementations;

import com.application.rest.models.Department;
import com.application.rest.persistence.DepartmentDAO;
import com.application.rest.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public Optional<Department> findDepartmentById(Long id) {
        return departmentDAO.findDepartmentById(id);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentDAO.findAllDepartments();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentDAO.saveDepartment(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentDAO.deleteDepartment(id);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }
}
