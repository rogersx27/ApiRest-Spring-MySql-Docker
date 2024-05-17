package com.application.rest.controllers.dto;

import com.application.rest.models.Department;
import com.application.rest.models.EmployeeHasBenefits;
import com.application.rest.models.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;

    private Long departmentId;

    private Long positionId;

    private List<EmployeeHasBenefits> employeeHasBenefits = new ArrayList<>();

    /**
    * Checks if any of the fields in the EmployeeDTO object are null.
    * @return Boolean value. Returns true if any of the fields (firstName, lastName, email, phoneNumber, hireDate, departmentId, positionId) are null.
    * Otherwise, returns false.
    */
    public Boolean isEmpty() {
        return Stream.of(firstName, lastName, email, phoneNumber, hireDate, departmentId, positionId)
                .anyMatch(Objects::isNull);
    }
}
