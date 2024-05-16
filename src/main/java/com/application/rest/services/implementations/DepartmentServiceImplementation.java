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
    public void saveDeparment(Department department) {
        departmentDAO.saveDeparment(department);
    }

    @Override
    public void deleteDeparment(Long id) {
        departmentDAO.deleteDeparment(id);
    }

    @Override
    public void updateDeparment(Department department) {
        departmentDAO.updateDeparment(department);
    }
}
