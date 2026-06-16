package com.abdullah.service;

import com.abdullah.dto.EmployeeSummaryDto;
import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import com.abdullah.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeQueryServiceImpl implements EmployeeQueryService{

    private final EmployeeRepository repo;

    @Override
    public List<Employee> getByDepartment(String dept) {
        return repo.findByDepartment(dept);
    }

    @Override
    public List<Employee> getByGender(Gender gender) {
        return repo.findByGenderJpql(gender);
    }

    @Override
    public List<Employee> search(String dept, Gender gender) {
        return repo.searchByDeptAndGender(dept, gender);
    }

    @Override
    public List<Employee> searchKeyword(String keyword) {
        return repo.searchByKeyword(keyword);
    }

    @Override
    public Double avgSalary() {
        return repo.avgSalary();
    }

    @Override
    public BigDecimal maxSalary() {
        return repo.maxSalary();
    }

    @Override
    public boolean existsEmail(String email) {
        return repo.existsEmail(email);
    }

    @Override
    public List<EmployeeSummaryDto> summary() {
        return repo.getEmployeeSummary();
    }

    @Override
    public List<Employee> topSalary() {
        return repo.orderBySalaryDesc()
                .stream()
                .limit(5)
                .toList();
    }

    @Override
    @Transactional
    public int updateSalary(Long id, BigDecimal salary) {
        return repo.updateSalary(id, salary);
    }

    @Override
    @Transactional
    public int deleteByStatus(EmployeeStatus status) {
        return repo.deleteByStatus(status);
    }
}
