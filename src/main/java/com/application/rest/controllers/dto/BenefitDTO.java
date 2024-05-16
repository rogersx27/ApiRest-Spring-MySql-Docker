package com.application.rest.controllers.dto;

import com.application.rest.models.EmployeeHasBenefits;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BenefitDTO {
    private Long id;
    private String description;
    private List<EmployeeHasBenefits> employeeHasBenefits;
}
