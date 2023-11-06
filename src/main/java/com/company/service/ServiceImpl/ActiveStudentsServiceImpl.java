package com.company.service.ServiceImpl;

import com.company.entity.ActiveStudents;
import com.company.entity.AttachmentEntity;
import com.company.payload.ActiveStudentsDto;
import com.company.payload.ApiResponse;
import com.company.repository.ActiveStudentsRepository;
import com.company.repository.AttachmentRepository;
import com.company.service.ActiveStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActiveStudentsServiceImpl implements ActiveStudentsService {

    @Autowired
    private ActiveStudentsRepository activeStudentsRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse addStudents(ActiveStudentsDto activeStudentsDto) {
        ActiveStudents activeStudents=new ActiveStudents();
        activeStudents.setFullName(activeStudentsDto.getFullName());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(activeStudentsDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }

        AttachmentEntity attachmentEntity = optional.get();
        activeStudents.setImage(attachmentEntity);

        activeStudentsRepository.save(activeStudents);
        return new ApiResponse("add students success", true);
    }


    @Override
    public ApiResponse editStudents(Long id, ActiveStudentsDto activeStudentsDto) {
        Optional<ActiveStudents> activeStudentsOptional = activeStudentsRepository.findById(id);

        if (!activeStudentsOptional.isPresent()){
            return new ApiResponse("not found students", false);
        }

        ActiveStudents activeStudents = activeStudentsOptional.get();
        activeStudents.setFullName(activeStudentsDto.getFullName());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(activeStudentsDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }
        activeStudentsRepository.save(activeStudents);

        return new ApiResponse("edit students success", true);
    }

    @Override
    public ApiResponse deleteStudent(Long id) {
        try{
            activeStudentsRepository.deleteById(id);
            return new ApiResponse("delete Activstdutents",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public ActiveStudents getByIdStudents(Long id) {
        return activeStudentsRepository.findById(id).orElse(new ActiveStudents());
    }

    @Override
    public Page<ActiveStudents> allStudents(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return activeStudentsRepository.findAll(pageable);
    }
}
