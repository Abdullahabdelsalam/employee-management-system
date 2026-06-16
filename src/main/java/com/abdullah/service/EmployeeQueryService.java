package com.abdullah.service;

import com.abdullah.dto.EmployeeSummaryDto;
import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeQueryService {

    List<Employee> getByDepartment(String dept);

    List<Employee> getByGender(Gender gender);

    List<Employee> search(String dept, Gender gender);

    List<Employee> searchKeyword(String keyword);

    Double avgSalary();

    BigDecimal maxSalary();

    boolean existsEmail(String email);

    List<EmployeeSummaryDto> summary();

    List<Employee> topSalary();

    int updateSalary(Long id, BigDecimal salary);

    int deleteByStatus(EmployeeStatus status);

}
