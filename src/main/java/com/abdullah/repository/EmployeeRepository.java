package com.abdullah.repository;

import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends
        JpaRepository<Employee, Long> {

    // Exact Match
    List<Employee> findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findByEmail(String email);

    // AND
    List<Employee> findByFirstNameAndLastName(
            String firstName,
            String lastName
    );

    // OR
    List<Employee> findByFirstNameOrLastName(
            String firstName,
            String lastName
    );

    // Department Relationship
    List<Employee> findByDepartmentName(
            String departmentName
    );

    // Profile Relationship
    List<Employee> findByGender(
            Gender gender
    );

    // Enum
    List<Employee> findByStatus(
            EmployeeStatus status
    );

    // Salary
    List<Employee> findBySalaryBetween(
            BigDecimal min,
            BigDecimal max
    );

    List<Employee> findBySalaryGreaterThan(
            BigDecimal salary
    );

    List<Employee> findBySalaryLessThan(
            BigDecimal salary
    );

    // Age
    List<Employee> findByAgeGreaterThan(
            Integer age
    );

    List<Employee> findByAgeLessThan(
            Integer age
    );

    // LIKE
    List<Employee> findByFirstNameContaining(
            String keyword
    );

    List<Employee> findByFirstNameContainingIgnoreCase(
            String keyword
    );

    List<Employee> findByFirstNameStartingWith(
            String prefix
    );

    List<Employee> findByFirstNameEndingWith(
            String suffix
    );

    // String
    List<Employee> findByStatus(String status);

    List<Employee> findByStatusFalse(String status);

    // NULL
    List<Employee> findByDepartmentIsNull();

    List<Employee> findByDepartmentIsNotNull();

    // IN
    List<Employee> findByIdIn(
            List<Long> ids
    );

    // EXISTS
    boolean existsByEmail(
            String email
    );

    boolean existsByNationalId(
            String nationalId
    );

    // COUNT
    long countByDepartmentName(
            String departmentName
    );

    long countByStatus(
            EmployeeStatus status
    );

    // ORDER
    List<Employee>
    findByDepartmentNameOrderBySalaryDesc(
            String departmentName
    );

    // TOP
    Employee findTopByOrderBySalaryDesc();

    Employee findTopByOrderBySalaryAsc();

    List<Employee> findTop5ByOrderBySalaryDesc();
}
