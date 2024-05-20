package com.application.rest.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {

    private static final Logger log = LoggerFactory.getLogger(DepartmentDTO.class);

    private Long id;
    private String name;
    private String description;

    /**
     * Checks if the 'name' and 'description' fields of the DepartmentDTO object are valid.
     * @throws IllegalArgumentException if the 'name' or 'description' fields are null or an empty string after trimming.
     */
    public void isValid() throws IllegalArgumentException {

        log.info("--> Validating Department DTO ...");

        boolean validateName = this.name != null && !this.name.trim().isEmpty();
        boolean validateDescription = this.description != null && !this.description.trim().isEmpty();

        if (!validateName) {
            log.error("----> Invalid name: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid name: it cannot be null or empty");
        }

        if (!validateDescription) {
            log.error("----> Invalid description: it cannot be null or empty");
            throw new IllegalArgumentException("Invalid description: it cannot be null or empty");
        }

        log.info("Department DTO is valid");
    }
}
