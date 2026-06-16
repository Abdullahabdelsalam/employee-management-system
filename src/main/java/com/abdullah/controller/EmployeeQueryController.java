package com.abdullah.controller;

import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import com.abdullah.service.EmployeeQueryService;
import com.abdullah.service.EmployeeQueryServiceImpl;
import com.abdullah.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import com.abdullah.dto.EmployeeSummaryDto;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/query")
@RequiredArgsConstructor
public class EmployeeQueryController {

    private final EmployeeQueryService service;

    private final EmployeeServiceImpl employeeService;

    @GetMapping("/page")
    public Page<Employee> getEmployees(
            @RequestParam int page,
            @RequestParam int size
    ) {
        return employeeService.getAllEmployees(page, size);
    }

    @GetMapping("/dept")
    public List<Employee> byDept(@RequestParam String dept) {
        return service.getByDepartment(dept);
    }

    @GetMapping("/gender")
    public List<Employee> byGender(@RequestParam Gender gender) {
        return service.getByGender(gender);
    }

    @GetMapping("/search")
    public List<Employee> search(
            @RequestParam String dept,
            @RequestParam Gender gender) {
        return service.search(dept, gender);
    }

    @GetMapping("/keyword")
    public List<Employee> keyword(@RequestParam String q) {
        return service.searchKeyword(q);
    }

    @GetMapping("/avg")
    public Double avg() {
        return service.avgSalary();
    }

    @GetMapping("/max")
    public BigDecimal max() {
        return service.maxSalary();
    }

    @GetMapping("/exists")
    public boolean exists(@RequestParam String email) {
        return service.existsEmail(email);
    }

    @GetMapping("/summary")
    public List<EmployeeSummaryDto> summary() {
        return service.summary();
    }

    @GetMapping("/top")
    public List<Employee> top() {
        return service.topSalary();
    }

    @PutMapping("/salary")
    public int updateSalary(
            @RequestParam Long id,
            @RequestParam BigDecimal salary) {
        return service.updateSalary(id, salary);
    }

    @DeleteMapping("/status")
    public int deleteByStatus(@RequestParam EmployeeStatus status) {
        return service.deleteByStatus(status);
    }
}
