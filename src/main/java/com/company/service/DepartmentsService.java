package com.company.service;

import com.company.entity.Departments;
import com.company.payload.ApiResponse;
import com.company.payload.DepartmentsDto;

import java.util.List;

public interface DepartmentsService {
    ApiResponse addDepartment(DepartmentsDto departmentsDto);

    ApiResponse editDepartment(Long id, DepartmentsDto departmentsDto);

    ApiResponse deleteDepartment(Long id);

    Departments departmentById(Long id);

    List<Departments> allDepartments();

    List<Departments> allDepartmentsByFacultyId(Long facultyid);

    List<Departments> allDepartmentsByCategoryId(Long categoryId);
}
