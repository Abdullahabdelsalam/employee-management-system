package com.abdullah.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
@SQLDelete(sql = "UPDATE employees SET deleted = true WHERE id = ?")
@SQLRestriction("deleted = false")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends BaseEntity {

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

    @Column(name = "national_id")
    private String nationalId;

    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonBackReference
//    @JsonIgnore
    private Department department;

    @OneToOne(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
//    @JsonManagedReference
    @JsonIgnore
    private EmployeeProfile employeeProfile;

    @OneToMany(
            mappedBy = "employee",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    @OrderBy("changeDate DESC")
    @JsonManagedReference
//    @JsonIgnore
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
//    @JsonBackReference
    @JsonIgnore
//    @JsonIgnoreProperties("employees")
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
//    @JsonManagedReference
    @JsonIgnore
//    @JsonIgnoreProperties("employees")
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
