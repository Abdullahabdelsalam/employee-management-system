package com.abdullah.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @OrderBy("changeDate DESC")
    private List<SalaryHistory> salaryHistory;

    public void setProfile(EmployeeProfile employeeProfile) {
        this.employeeProfile = employeeProfile;
        employeeProfile.setEmployee(this);

    }
     public void addSalaryHistory(SalaryHistory salaryHistory) {
        this.salaryHistory.add(salaryHistory);
        salaryHistory.setEmployee(this);
     }

     public void removeSalaryHistory(SalaryHistory salaryHistory) {
        this.salaryHistory.remove(salaryHistory);
        salaryHistory.setEmployee(null);
     }

//    setSalaryHistory(List<SalaryHistory> salaryHistory) {
//        this.salaryHistory = salaryHistory;
//        for (SalaryHistory salaryHistoryItem : salaryHistory) {
//            salaryHistoryItem.setEmployee(this);
//        }
//    }

}
