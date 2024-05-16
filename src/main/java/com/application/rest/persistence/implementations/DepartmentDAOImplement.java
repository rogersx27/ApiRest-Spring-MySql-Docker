package com.application.rest.persistence.implementations;

import com.application.rest.models.Department;
import com.application.rest.persistence.DepartmentDAO;
import com.application.rest.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DepartmentDAOImplement implements DepartmentDAO {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Optional<Department> findDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public List<Department> findAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public void saveDeparment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public void deleteDeparment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public void updateDeparment(Department department) {
        departmentRepository.save(department);
    }
}
