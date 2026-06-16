package com.abdullah.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            nullable = false,
            unique = true,
            length = 100
    )
    private String name;

    @Column(
            length = 500
    )
    private String description;

    @OneToMany(
            mappedBy = "department"
    )
    @JsonManagedReference
    private List<Employee> employees;

    private void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }

    private void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.setDepartment(null);
    }
}
