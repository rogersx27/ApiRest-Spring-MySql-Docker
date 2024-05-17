package com.application.rest.repositories;

import com.application.rest.models.Employee;
import com.application.rest.models.Position;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Employee> findEmployeeByEmail(String email);

    Optional<Employee> findEmployeeByPhoneNumber(String phoneNumber);

    Collection<Employee> findEmployeeByHireDate(LocalDate hireDate);

    List<Employee> findByPosition(Position position);
}
