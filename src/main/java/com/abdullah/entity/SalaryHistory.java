package com.abdullah.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "salary_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalaryHistory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,
            precision = 15,
            scale = 2)
    private BigDecimal oldSalary;

    @Column(nullable = false,
            precision = 15,
            scale = 2)
    private BigDecimal newSalary;

    @Column(nullable = false)
    private LocalDate changeDate;

    @Column(length = 500)
    private String reason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "employee_id",
            nullable = false
    )
    @JsonBackReference
    private Employee employee;

}
