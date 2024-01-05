package com.company.service;

import com.company.dto.CenterAndDepartmentsDtoGet;
import com.company.entity.Facultys;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsDto;

import java.util.List;

public interface CenterAndDepartmentsService {
    ApiResponse addCenterAndDepartment(CenterAndDepartmentsDto centerAndDepartmentsDto);

    ApiResponse editCenterAndDepartment(Long id, CenterAndDepartmentsDto centerAndDepartmentsDto);

    ApiResponse deleteCenterAndDepartment(Long id);

    CenterAndDepartmentsDtoGet сenterAndDepartmentById(Long id);

    List<CenterAndDepartmentsDtoGet> allCenterAndDepartments();
}
