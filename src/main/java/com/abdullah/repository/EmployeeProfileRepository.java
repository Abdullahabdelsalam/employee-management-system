package com.abdullah.repository;

import com.abdullah.entity.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile,Long> {
}
