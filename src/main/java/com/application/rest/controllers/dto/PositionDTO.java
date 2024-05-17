package com.application.rest.controllers.dto;

import com.application.rest.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PositionDTO {

    private Long id;
    private String title;
    private String description;
    private Float salary;

    private List<Employee> employeesList = new ArrayList<>();
}
