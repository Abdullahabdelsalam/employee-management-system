package com.abdullah.dto;

import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeSearchDto {
    private String department;

    private Gender gender;

    private EmployeeStatus status;

    private BigDecimal minSalary;

    private BigDecimal maxSalary;

    private Integer minAge;

    private Integer maxAge;
}
