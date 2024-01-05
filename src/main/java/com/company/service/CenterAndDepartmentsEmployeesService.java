package com.company.service;

import com.company.dto.CenterAndDepartmentsEmployeesGet;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsEmployeesDto;

import java.util.List;

public interface CenterAndDepartmentsEmployeesService {
    ApiResponse addCenterAndDepartmentsEmployees(CenterAndDepartmentsEmployeesDto centerAndDepartmentsEmployeesDto);

    ApiResponse editCenterAndDepartmentsEmployees(Long id, CenterAndDepartmentsEmployeesDto centerAndDepartmentsEmployeesDto);

    ApiResponse deleteCenterAndDepartmentsEmployees(Long id);

    CenterAndDepartmentsEmployeesGet centerAndDepartmentsEmployeesById(Long id);

    List<CenterAndDepartmentsEmployeesGet> allCenterAndDepartmentsEmployees();
}
