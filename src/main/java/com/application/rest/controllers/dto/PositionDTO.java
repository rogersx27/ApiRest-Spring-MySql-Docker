package com.application.rest.controllers.dto;

import com.application.rest.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionDTO {

    private static final Logger log = LoggerFactory.getLogger(DepartmentDTO.class);

    private Long id;
    private String title;
    private String description;
    private Float salary;

    public void isValid() throws IllegalArgumentException {

        log.info("--> Validating Position DTO ...");

        boolean validateTitle = this.title != null && !this.title.trim().isEmpty();
        boolean validateDescription = this.description != null && !this.description.trim().isEmpty();
        boolean validateSalary = this.salary != null && this.salary > 0;

        if (!validateTitle) {
            log.error("----> Invalid title: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid title: it cannot be null or empty");
        }

        if (!validateDescription) {
            log.error("----> Invalid description: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid description: it cannot be null or empty");
        }

        if (!validateSalary) {
            log.error("----> Invalid salary: it cannot be null or less than or equal to zero");
            throw new IllegalArgumentException("Invalid salary: it cannot be null or less than or equal to zero");
        }

        log.info("Position DTO is valid");
    }
}
