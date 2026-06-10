package com.abdullah.service;

import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {

    List<Employee> getByFirstName(String name);

    List<Employee> getByDepartment(String department);

    List<Employee> getByGender(Gender gender);

    List<Employee> getSalaryRange(
            BigDecimal min,
            BigDecimal max
    );

    List<Employee> search(String keyword);

    Employee highestSalary();

    boolean emailExists(String email);

    long countByDepartment(String department);

    List<Employee> topFiveSalary();

    List<Employee> getByStatus(
            EmployeeStatus status
    );
}
