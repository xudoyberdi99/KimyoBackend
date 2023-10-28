package com.company.service.ServiceImpl;

import com.company.entity.ActiveStudents;
import com.company.payload.ActiveStudentsDto;
import com.company.payload.ApiResponse;
import com.company.repository.ActiveStudentsRepository;
import com.company.repository.AttachmentRepository;
import com.company.service.ActiveStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ActiveStudentsServiceImpl implements ActiveStudentsService {

    @Autowired
    private ActiveStudentsRepository activeStudentsRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse addStudents(ActiveStudentsDto activeStudentsDto) {

        return null;
    }

    @Override
    public ApiResponse editStudents(Long id, ActiveStudentsDto activeStudentsDto) {
        return null;
    }

    @Override
    public ApiResponse deleteStudent(Long id) {
        return null;
    }

    @Override
    public ActiveStudents getByIdStudents(Long id) {
        return null;
    }

    @Override
    public Page<ActiveStudents> allStudents(int page, int size) {
        return null;
    }
}
