package com.abdullah.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects" )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            unique = true,
            length = 100
    )
    private String name;

    @Column(length = 1000)
    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    @ManyToMany(
            mappedBy = "projects"
    )
    private Set<Employee> employees = new HashSet<>();
}
