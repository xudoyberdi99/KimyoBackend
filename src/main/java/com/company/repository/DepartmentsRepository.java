package com.company.repository;

import com.company.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentsRepository extends JpaRepository<Departments,Long> {
    @Query(value = "select * from departments d where d.facultys_id=:facultyId",nativeQuery = true)
    List<Departments> allDepartmentsByFacultyId(Long facultyId);

    List<Departments> findAllByCategory_Id(Long categoryId);
}
