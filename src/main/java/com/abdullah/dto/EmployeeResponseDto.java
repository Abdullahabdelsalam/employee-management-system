package com.abdullah.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EmployeeResponseDto {
    private Long id;

    private String fullName;

    private String email;

    private String jobTitle;
}
