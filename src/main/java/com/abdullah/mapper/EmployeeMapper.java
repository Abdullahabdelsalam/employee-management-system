package com.abdullah.mapper;

import com.abdullah.dto.EmployeeRequestDto;
import com.abdullah.dto.EmployeeResponseDto;
import com.abdullah.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(
            EmployeeRequestDto dto
    );

    @Mapping(
            target = "fullName",

            expression =
                    "java(employee.getFirstName() + \" \" + employee.getLastName())"
    )

    @Mapping(
            target="department",

            source="department.name"
    )

    @Mapping(
            target="status",

            expression =
                    "java(employee.getStatus().name())"
    )
    EmployeeResponseDto toDto(
            Employee employee
    );
}
