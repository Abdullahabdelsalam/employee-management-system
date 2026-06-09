package com.abdullah.repository;

import com.abdullah.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends
        JpaRepository<Employee, Long> {
}
