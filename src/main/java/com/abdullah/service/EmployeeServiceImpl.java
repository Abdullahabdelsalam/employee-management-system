package com.abdullah.service;

import com.abdullah.dto.EmployeeRequestDto;
import com.abdullah.dto.EmployeeResponseDto;
import com.abdullah.dto.EmployeeSearchDto;
import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import com.abdullah.mapper.EmployeeMapper;
import com.abdullah.repository.EmployeeRepository;
import com.abdullah.specification.EmployeeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    private final EmployeeMapper mapper;

    public EmployeeResponseDto save(
            EmployeeRequestDto dto){

        Employee employee
                = mapper.toEntity(dto);

        Employee saved
                = employeeRepository.save(employee);

        return mapper.toDto(saved);

    }

    public List<Employee> search(
            EmployeeSearchDto dto) {

        Specification<Employee> spec = Specification.where((Specification<Employee>) null);
        if (dto.getDepartment() != null) {

            spec = spec.and(

                    EmployeeSpecification.hasDepartment(

                                    dto.getDepartment()

                    )

            );

        }
        if(dto.getGender()!=null){

            spec=spec.and(

                    EmployeeSpecification
                            .hasGender(
                                    dto.getGender()
                            )

            );

        }
        if(dto.getStatus()!=null){

            spec=spec.and(

                    EmployeeSpecification
                            .hasStatus(
                                    dto.getStatus()
                            )

            );

        }
        if(dto.getMinSalary()!=null){

            spec=spec.and(

                    EmployeeSpecification
                            .salaryGreaterThan(
                                    dto.getMinSalary()
                            )

            );

        }
        if(dto.getMaxSalary()!=null){

            spec=spec.and(

                    EmployeeSpecification
                            .salaryLessThan(
                                    dto.getMaxSalary()
                            )

            );

        }
        return employeeRepository.findAll(spec);
    }


    public Page<Employee> getAllEmployees(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> getByFirstName(String name) {
        return employeeRepository
                .findDistinctByFirstName(name);
    }

    @Override
    public List<Employee> getByDepartment(
            String department) {

        return employeeRepository
                .findDistinctByDepartmentName(
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
