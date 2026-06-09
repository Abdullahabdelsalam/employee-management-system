package com.abdullah.entity;

import com.abdullah.dto.EmployeeProfile;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    private String firstName ;

    private String lastName ;

    private String email;

    private String phoneNumber;

    private Integer age;

    private BigDecimal salary;

    private String jobTitle;

    private String nationality;

    private LocalDate hireDate;

    private Boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "department_id")
    private Department department;

    @OneToOne(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private EmployeeProfile employeeProfile;

    public void setProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
        employeeProfile.setEmployee(this);

    }
}
