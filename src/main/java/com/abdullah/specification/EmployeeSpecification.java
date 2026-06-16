package com.abdullah.specification;

import com.abdullah.entity.Employee;
import com.abdullah.entity.EmployeeStatus;
import com.abdullah.entity.Gender;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class EmployeeSpecification {
    public static Specification<Employee>
    hasDepartment(String department) {

        return (root, query, cb) ->

                cb.equal(
                        root.get("department").get("name"),
                        department
                );

    }

    public static Specification<Employee>
    hasGender(Gender gender){

        return (root,query,cb)->

                cb.equal(
                        root.get("profile")
                                .get("gender"),

                        gender
                );

    }

    public static Specification<Employee>
    hasStatus(EmployeeStatus status){

        return (root,query,cb)->

                cb.equal(
                        root.get("status"),
                        status
                );

    }

    public static Specification<Employee>
    salaryGreaterThan(
            BigDecimal salary){

        return (root,query,cb)->

                cb.greaterThan(
                        root.get("salary"),
                        salary
                );

    }

    public static Specification<Employee>
    salaryLessThan(
            BigDecimal salary){

        return (root,query,cb)->

                cb.lessThan(
                        root.get("salary"),
                        salary
                );

    }

    public static Specification<Employee>
    ageGreaterThan(
            Integer age){

        return (root,query,cb)->

                cb.greaterThan(
                        root.get("age"),
                        age
                );

    }

    public static Specification<Employee>
    ageLessThan(
            Integer age){

        return (root,query,cb)->

                cb.lessThan(
                        root.get("age"),
                        age
                );

    }
}
