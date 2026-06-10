package com.abdullah.service;

import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import com.abdullah.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getByFirstName(String name) {
        return employeeRepository
                .findByFirstName(name);
    }

    @Override
    public List<Employee> getByDepartment(
            String department) {

        return employeeRepository
                .findByDepartmentName(
                        department
                );
    }

    @Override
    public List<Employee> getByGender(
            Gender gender) {

        return employeeRepository
                .findByGender(
                        gender
                );
    }

    @Override
    public List<Employee> getSalaryRange(
            BigDecimal min,
            BigDecimal max) {

        return employeeRepository
                .findBySalaryBetween(
                        min,
                        max
                );
    }

    @Override
    public List<Employee> search(
            String keyword) {

        return employeeRepository
                .findByFirstNameContainingIgnoreCase(
                        keyword
                );
    }

    @Override
    public Employee highestSalary() {

        return employeeRepository
                .findTopByOrderBySalaryDesc();
    }

    @Override
    public boolean emailExists(
            String email) {

        return employeeRepository
                .existsByEmail(email);
    }

    @Override
    public long countByDepartment(
            String department) {

        return employeeRepository
                .countByDepartmentName(
                        department
                );
    }

    @Override
    public List<Employee> topFiveSalary() {

        return employeeRepository
                .findTop5ByOrderBySalaryDesc();
    }

    @Override
    public List<Employee> getByStatus(
            EmployeeStatus status) {

        return employeeRepository
                .findByStatus(status);
    }

}
