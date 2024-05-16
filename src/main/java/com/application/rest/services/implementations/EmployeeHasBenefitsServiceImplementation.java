package com.application.rest.services.implementations;

import com.application.rest.models.EmployeeHasBenefits;
import com.application.rest.persistence.EmployeeDAO;
import com.application.rest.persistence.EmployeeHasBenefitsDAO;
import com.application.rest.services.EmployeeHasBenefitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeHasBenefitsServiceImplementation implements EmployeeHasBenefitsService {

    @Autowired
    private EmployeeHasBenefitsDAO employeeHasBenefitsDAO;
    @Override
    public List<EmployeeHasBenefits> findAll() {
        return employeeHasBenefitsDAO.findAll();
    }

    @Override
    public EmployeeHasBenefits findById(Long id) {
        return employeeHasBenefitsDAO.findById(id);
    }

    @Override
    public List<EmployeeHasBenefits> findByEmployeeId(Long employeeId) {
        return employeeHasBenefitsDAO.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeHasBenefits> findByBenefitId(Long benefitId) {
        return employeeHasBenefitsDAO.findByBenefitId(benefitId);
    }

    @Override
    public void save(EmployeeHasBenefits employeeHasBenefits) {
        employeeHasBenefitsDAO.save(employeeHasBenefits);
    }

    @Override
    public void delete(Long id) {
        employeeHasBenefitsDAO.delete(id);
    }

    @Override
    public void update(EmployeeHasBenefits employeeHasBenefits) {
        employeeHasBenefitsDAO.update(employeeHasBenefits);
    }
}
