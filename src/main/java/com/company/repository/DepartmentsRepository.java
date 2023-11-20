package com.company.repository;

import com.company.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentsRepository extends JpaRepository<Departments,Long> {
}
