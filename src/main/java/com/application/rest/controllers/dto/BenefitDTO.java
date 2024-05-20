package com.application.rest.controllers.dto;

import com.application.rest.models.EmployeeHasBenefits;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BenefitDTO {

    private static final Logger log = LoggerFactory.getLogger(DepartmentDTO.class);

    private Long id;
    private String description;
    private List<EmployeeHasBenefits> employeeHasBenefits;

    /**
     * Checks if the 'description' field of the BenefitDTO object is valid.
     * @throws IllegalArgumentException if the 'description' field is null or an empty string after trimming.
     */
    public void isValid() throws IllegalArgumentException {

        log.info("--> Validating Benefit DTO ...");

        boolean validateDescription = this.description != null && !this.description.trim().isEmpty();
        if (!validateDescription) {
            log.error("----> Description cannot be null or empty");
            throw new IllegalArgumentException("Description cannot be null or empty");
        }

        log.info("Benefit DTO is valid");
    }
}
