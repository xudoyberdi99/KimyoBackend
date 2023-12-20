package com.company.service;

import com.company.entity.Facultys;
import com.company.payload.ApiResponse;
import com.company.payload.FacultyDto;

import java.util.List;

public interface FacultyService {
    ApiResponse addFaculty(FacultyDto facultyDto);

    ApiResponse editFaculty(Long id, FacultyDto facultyDto);

    ApiResponse deleteFaculty(Long id);

    Facultys facultyById(Long id);

    List<Facultys> allFaculty();

    List<Facultys> facultyByCategoryId(Long categoryId);
}
