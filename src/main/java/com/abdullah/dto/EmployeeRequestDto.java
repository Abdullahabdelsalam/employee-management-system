package com.abdullah.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    @NotEmpty
    @Size(min=3, max=50)
    protected String firstName;

    @NotBlank
    @Size(min = 3 , max = 50 )
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^01[0125][0-9]{8}$"
    )
    private String phoneNumber;

    @NotBlank
    @Min(18)
    @Max(65)
    private Integer age;

    @NotNull
    @Positive
    private BigDecimal salary;

    @NotBlank
    @Size(max=100)
    private String jobTitle;

    @NotBlank
    @Pattern(
            regexp = "^[0-9]{14}$"
    )
    private String nationalId;

    @NotNull
    @PastOrPresent
    private LocalDate hireDate;

    @NotNull
    private Boolean active;
}
