package com.application.rest.persistence.implementations;

import com.application.rest.models.EmployeeHasBenefits;
import com.application.rest.persistence.EmployeeHasBenefitsDAO;
import com.application.rest.repositories.EmployeeHasBenefitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeHasBenefitsDAOImplement implements EmployeeHasBenefitsDAO {

    @Autowired
    private EmployeeHasBenefitsRepository employeeHasBenefitsRepository;

    @Override
    public List<EmployeeHasBenefits> findAll() {
        return (List<EmployeeHasBenefits>) employeeHasBenefitsRepository.findAll();
    }

    @Override
    public EmployeeHasBenefits findById(Long id) {
        return employeeHasBenefitsRepository.findById(id).get();
    }

    @Override
    public List<EmployeeHasBenefits> findByEmployeeId(Long employeeId) {
        return employeeHasBenefitsRepository.findByEmployeeId(employeeId);
    }

    @Override
    public List<EmployeeHasBenefits> findByBenefitId(Long benefitId) {
        return employeeHasBenefitsRepository.findByBenefitId(benefitId);
    }

    @Override
    public void save(EmployeeHasBenefits employeeHasBenefits) {
        employeeHasBenefitsRepository.save(employeeHasBenefits);
    }

    @Override
    public void delete(Long id) {
        employeeHasBenefitsRepository.deleteById(id);
    }

    @Override
    public void update(EmployeeHasBenefits employeeHasBenefits) {
        employeeHasBenefitsRepository.save(employeeHasBenefits);
    }
}
