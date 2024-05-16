package com.application.rest.persistence;

import com.application.rest.models.EmployeeHasBenefits;

import java.util.List;

public interface EmployeeHasBenefitsDAO {

    List<EmployeeHasBenefits> findAll();

    EmployeeHasBenefits findById(Long id);

    List<EmployeeHasBenefits> findByEmployeeId(Long employeeId);

    List<EmployeeHasBenefits> findByBenefitId(Long benefitId);

    void save(EmployeeHasBenefits employeeHasBenefits);

    void delete(Long id);

    void update(EmployeeHasBenefits employeeHasBenefits);

}
