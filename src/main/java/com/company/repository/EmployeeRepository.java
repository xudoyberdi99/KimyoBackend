package com.company.repository;

import com.company.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
    Boolean existsByEmail(String email);
    List<Employees> findAllByDepartments_id(Long departmentid);
}
