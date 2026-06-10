package com.abdullah.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
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

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "employee_project",
            joinColumns =  @JoinColumn(
                    name = "employee_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "project_id"
            )
    )
    private Set<Project> projects = new HashSet<>();

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "employee_skill",
            joinColumns = @JoinColumn(
                    name = "employee_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "skill_id"
            )
    )
    private Set<Skill> skills = new HashSet<>();

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

     public  void addProject(Project project) {
        projects.add(project);
         project.getEmployees().add(this);
     }

     public void removeProject(Project project) {
        projects.remove(project);
        project.getEmployees().remove(this);
     }

     public void  addSkill(Skill skill) {
        skills.add(skill);
        skill.getEmployees().add(this);
     }

     public void removeSkill(Skill skill) {
        skills.remove(skill);
        skill.getEmployees().remove(this);
     }

}
