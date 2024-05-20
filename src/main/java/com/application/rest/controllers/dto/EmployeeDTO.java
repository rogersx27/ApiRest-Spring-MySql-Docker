package com.application.rest.controllers.dto;

import com.application.rest.models.EmployeeHasBenefits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private static final Logger log = LoggerFactory.getLogger(DepartmentDTO.class);

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;

    private Long departmentId;

    private Long positionId;

    private List<EmployeeHasBenefits> employeeHasBenefits = new ArrayList<>();

    public void isValid() throws IllegalArgumentException {

        log.info("--> Validating Employee DTO ...");

        boolean validateFirstName = this.firstName != null && !this.firstName.trim().isEmpty();
        boolean validateLastName = this.lastName != null && !this.lastName.trim().isEmpty();
        boolean validateEmail = this.email != null && !this.email.trim().isEmpty();
        boolean validatePhoneNumber = this.phoneNumber != null && !this.phoneNumber.trim().isEmpty();
        boolean validateHireDate = this.hireDate != null;
        boolean validateDepartmentId = this.departmentId != null;
        boolean validatePositionId = this.positionId != null;

        if (!validateFirstName) {
            log.error("----> Invalid first name: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid first name: it cannot be null or empty");
        }

        if (!validateLastName) {
            log.error("----> Invalid last name: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid last name: it cannot be null or empty");
        }

        if (!validateEmail) {
            log.error("----> Invalid email: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid email: it cannot be null or empty");
        }

        if (!validatePhoneNumber) {
            log.error("----> Invalid phone number: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid phone number: it cannot be null or empty");
        }

        if (!validateHireDate) {
            log.error("----> Invalid hire date: it cannot be null");
            throw new IllegalArgumentException("Invalid hire date: it cannot be null");
        }

        if (!validateDepartmentId) {
            log.error("----> Invalid department id: it cannot be null");
            throw new IllegalArgumentException("Invalid department id: it cannot be null");
        }

        if (!validatePositionId) {
            log.error("----> Invalid position id: it cannot be null");
            throw new IllegalArgumentException("Invalid position id: it cannot be null");
        }

        log.info("Employee DTO is valid");
    }
}
