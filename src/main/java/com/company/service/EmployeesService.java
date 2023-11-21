package com.company.service;

import com.company.entity.Employees;
import com.company.payload.ApiResponse;
import com.company.payload.EmployeesDto;

import java.util.List;

public interface EmployeesService {
    ApiResponse addEmployee(EmployeesDto employeesDto);

    ApiResponse editEmployee(Long id, EmployeesDto employeesDto);

    ApiResponse deleteEmployee(Long id);

    Employees employeeByid(Long id);

    List<Employees> allEmployeeByDepartmentId(Long id);
}
