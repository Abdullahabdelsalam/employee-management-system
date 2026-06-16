package com.abdullah.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

     private String address;

     @Column( name = "birth_date")
     private LocalDate dateOfBirth;

    private String emergencyContactName;

    private String emergencyContactPhone;

    @OneToOne
    @JoinColumn(name = "employee_id",
                nullable = false,
                unique = true
    )
    @JsonBackReference
    private Employee employee;
}
