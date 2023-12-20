package com.company.repository;

import com.company.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {
    Boolean existsByEmail(String email);
    Boolean existsByEmailAndIdNot(String email, Long id);
    List<Employees> findAllByDepartments_id(Long departmentid);
}
