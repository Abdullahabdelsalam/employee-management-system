package com.abdullah.controller;

import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import com.abdullah.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeQueryController {


        private final EmployeeService employeeService;

        @GetMapping("/name/{name}")
        public List<Employee> getByName(
                @PathVariable String name) {

            return employeeService
                    .getByFirstName(name);
        }

        @GetMapping("/department/{department}")
        public List<Employee> getByDepartment(
                @PathVariable String department) {

            return employeeService
                    .getByDepartment(department);
        }

        @GetMapping("/gender/{gender}")
        public List<Employee> getByGender(
                @PathVariable Gender gender) {

            return employeeService
                    .getByGender(gender);
        }

        @GetMapping("/salary")
        public List<Employee> salaryRange(
                @RequestParam BigDecimal min,
                @RequestParam BigDecimal max) {

            return employeeService
                    .getSalaryRange(min, max);
        }

        @GetMapping("/search")
        public List<Employee> search(
                @RequestParam String keyword) {

            return employeeService
                    .search(keyword);
        }

        @GetMapping("/highest-salary")
        public Employee highestSalary() {

            return employeeService
                    .highestSalary();
        }

        @GetMapping("/exists")
        public boolean exists(
                @RequestParam String email) {

            return employeeService
                    .emailExists(email);
        }

        @GetMapping("/count")
        public long count(
                @RequestParam String department) {

            return employeeService
                    .countByDepartment(
                            department
                    );
        }

        @GetMapping("/top5")
        public List<Employee> topFive() {

            return employeeService
                    .topFiveSalary();
        }

        @GetMapping("/status/{status}")
        public List<Employee> status(
                @PathVariable EmployeeStatus status) {

            return employeeService
                    .getByStatus(status);
        }
}
