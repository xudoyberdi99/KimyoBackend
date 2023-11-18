package com.company.service;

import com.company.entity.ActiveStudents;
import com.company.payload.ActiveStudentsDto;
import com.company.payload.ApiResponse;
import org.springframework.data.domain.Page;

public interface ActiveStudentsService {
    ApiResponse addStudents(ActiveStudentsDto activeStudentsDto);

    ApiResponse editStudents(Long id, ActiveStudentsDto activeStudentsDto);

    ApiResponse deleteStudent(Long id);

    ActiveStudents getByIdStudents(Long id);

    Page<ActiveStudents> allStudents(int page, int size);

    Page<ActiveStudents> allgraduated(int page, int size);
}
