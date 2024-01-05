package com.company.repository;

import com.company.entity.CenterAndDepartmentsEmployees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CenterAndDepartmentsEmployeesRepository extends JpaRepository<CenterAndDepartmentsEmployees,Long> {
    @Query(value = "select * from center_departments_employees where center_and_departments_id=:id",nativeQuery = true)
    List<CenterAndDepartmentsEmployees> findAllByCenterAndDepartments(Long id);

    Boolean existsByEmailAndIdNot(String email, Long id);
    Boolean existsByEmail(String email);
}
