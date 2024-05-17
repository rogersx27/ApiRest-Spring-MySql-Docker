package com.application.rest.controllers.dto;

import com.application.rest.models.Benefit;
import com.application.rest.models.Employee;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeHasBenefitsDTO {

    private Long id;

    private Employee employee;
    private Benefit benefit;

    private Date startDate;
    private Date endDate;
}
