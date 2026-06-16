package com.abdullah.repository;

import com.abdullah.dto.EmployeeSummaryDto;
import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepository extends
        JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

    Page<Employee> findAll(Pageable pageable);

    // Exact Match
    List<Employee> findDistinctByFirstName(String firstName);

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
    List<Employee> findDistinctByDepartmentName(
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

    //___________________________________==( USD JPQL )== ________________________________________________

    // ========================
    // BASIC JPQL
    // ========================

    @Query("SELECT e FROM Employee e")
    List<Employee> getAll();

    @Query("SELECT e FROM Employee e WHERE e.firstName = :name")
    List<Employee> findByName(@Param("name") String name);

    // ========================
    // JOIN QUERIES
    // ========================

    @Query("""
           SELECT e
           FROM Employee e
           JOIN e.department d
           WHERE d.name = :dept
           """)
    List<Employee> findByDepartment(@Param("dept") String dept);

    @Query("""
        SELECT e
        FROM Employee e
        WHERE e.gender = :gender
        """)
    List<Employee> findByGenderJpql(
            @Param("gender") Gender gender
    );

    @Query("""
       SELECT e
       FROM Employee e
       JOIN e.department d
       WHERE d.name = :dept
       AND e.gender = :gender
       """)
    List<Employee> searchByDeptAndGender(
            @Param("dept") String dept,
            @Param("gender") Gender gender
    );

    // ========================
    // LIKE SEARCH
    // ========================

    @Query("""
           SELECT e
           FROM Employee e
           WHERE LOWER(e.firstName)
           LIKE LOWER(CONCAT('%', :keyword, '%'))
           """)
    List<Employee> searchByKeyword(@Param("keyword") String keyword);

    // ========================
    // AGGREGATION
    // ========================

    @Query("SELECT COUNT(e) FROM Employee e")
    long countAll();

    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double avgSalary();

    @Query("SELECT MAX(e.salary) FROM Employee e")
    BigDecimal maxSalary();

    @Query("SELECT MIN(e.salary) FROM Employee e")
    BigDecimal minSalary();

    @Query("SELECT SUM(e.salary) FROM Employee e")
    BigDecimal totalSalary();

    // ========================
    // EXISTS (JPQL STYLE)
    // ========================

    @Query("""
           SELECT COUNT(e) > 0
           FROM Employee e
           WHERE e.email = :email
           """)
    boolean existsEmail(@Param("email") String email);

    // ========================
    // DTO PROJECTION
    // ========================

    @Query("""
           SELECT new com.abdullah.dto.EmployeeSummaryDto(
               e.firstName,
               e.salary
           )
           FROM Employee e
           """)
    List<EmployeeSummaryDto> getEmployeeSummary();

    // ========================
    // ORDER BY / TOP
    // ========================

    @Query("""
           SELECT e
           FROM Employee e
           ORDER BY e.salary DESC
           """)
    List<Employee> orderBySalaryDesc();

    @Query("""
           SELECT e
           FROM Employee e
           ORDER BY e.salary DESC
           """)
    List<Employee> topEmployees(); // use limit in service

    // ========================
    // JOIN FETCH (ANTI N+1)
    // ========================

    @Query("""
           SELECT e
           FROM Employee e
           JOIN FETCH e.department
           """)
    List<Employee> findAllWithDepartment();

    @Query("""
           SELECT e
           FROM Employee e
           JOIN FETCH e.employeeProfile
           """)
    List<Employee> findAllWithProfile();

    // ========================
    // UPDATE (MODIFY)
    // ========================

    @Modifying
    @Query("""
           UPDATE Employee e
           SET e.salary = :salary
           WHERE e.id = :id
           """)
    int updateSalary(@Param("id") Long id,
                     @Param("salary") BigDecimal salary);

    // ========================
    // DELETE (MODIFY)
    // ========================

    @Modifying
    @Query("""
           DELETE FROM Employee e
           WHERE e.status = :status
           """)
    int deleteByStatus(@Param("status") EmployeeStatus status);

}
