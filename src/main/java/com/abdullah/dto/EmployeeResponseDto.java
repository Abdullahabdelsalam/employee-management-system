package com.abdullah.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class EmployeeResponseDto {
    private Long id;

    private String fullName;

    private String email;

    private BigDecimal salary;

    private String department;

    private String status;
}
