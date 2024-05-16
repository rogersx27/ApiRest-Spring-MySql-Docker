package com.application.rest.repositories;

import com.application.rest.models.EmployeeHasBenefits;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeHasBenefitsRepository  extends CrudRepository<EmployeeHasBenefits, Long>{
    List<EmployeeHasBenefits> findByEmployeeId(Long employeeId);
    List<EmployeeHasBenefits> findByBenefitId(Long benefitId);
}
