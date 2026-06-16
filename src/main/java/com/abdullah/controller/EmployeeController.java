package com.abdullah.controller;

import com.abdullah.dto.EmployeeRequestDto;
import com.abdullah.dto.EmployeeResponseDto;
import com.abdullah.dto.EmployeeSearchDto;
import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import com.abdullah.response.ApiResponse;
import com.abdullah.service.EmployeeService;
import com.abdullah.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

        private final EmployeeService employeeService;
        private final EmployeeServiceImpl employeeServiceImpl;

//    @PostMapping
//    public EmployeeResponseDto save(
//
//            @Valid
//
//            @RequestBody
//
//            EmployeeRequestDto dto
//
//    ){
//
//        return employeeServiceImpl.save(dto);
//
//    }
//
//    @PostMapping("/search")
//    public List<Employee> search(
//
//            @RequestBody
//            EmployeeSearchDto dto
//
//    ){
//
//        return employeeServiceImpl.search(dto);
//
//    }

    @PostMapping
    public ApiResponse<EmployeeResponseDto>

    save(

            @RequestBody

            EmployeeRequestDto dtoo

    ){

        return ApiResponse

                .<EmployeeResponseDto>builder()

                .success(true)

                .message("Employee Created")

                .data(

                        employeeServiceImpl.save(dtoo)

                )

                .build();

    }

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
