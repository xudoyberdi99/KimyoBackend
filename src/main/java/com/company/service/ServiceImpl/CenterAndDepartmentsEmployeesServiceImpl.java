package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.CenterAndDepartmentsEmployeesGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.CenterAndDepartments;
import com.company.entity.CenterAndDepartmentsEmployees;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsEmployeesDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.CenterAndDepartmentsEmployeesRepository;
import com.company.repository.CenterAndDepartmentsRepository;
import com.company.service.CenterAndDepartmentsEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CenterAndDepartmentsEmployeesServiceImpl implements CenterAndDepartmentsEmployeesService {
    @Autowired
    private CenterAndDepartmentsEmployeesRepository centerAndDepartmentsEmployeesRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private CenterAndDepartmentsRepository centerAndDepartmentsRepository;
    @Value("${upload.server}")
    private String serverPath;
    @Override
    public ApiResponse addCenterAndDepartmentsEmployees(CenterAndDepartmentsEmployeesDto centerAndDepartmentsEmployeesDto) {
        Boolean existsByEmail = centerAndDepartmentsEmployeesRepository.existsByEmail(centerAndDepartmentsEmployeesDto.getEmail());
        if (existsByEmail){
            return new ApiResponse("Already exists person", false);
        }
        CenterAndDepartmentsEmployees centerAndDepartmentsEmployees=new CenterAndDepartmentsEmployees();

        centerAndDepartmentsEmployees.setBiographyEN(centerAndDepartmentsEmployeesDto.getBiographyEN());
        centerAndDepartmentsEmployees.setBiographyKR(centerAndDepartmentsEmployeesDto.getBiographyKR());
        centerAndDepartmentsEmployees.setBiographyUZ(centerAndDepartmentsEmployeesDto.getBiographyUZ());
        centerAndDepartmentsEmployees.setBiographyRU(centerAndDepartmentsEmployeesDto.getBiographyRU());
        centerAndDepartmentsEmployees.setDegree(centerAndDepartmentsEmployeesDto.getDegree());
        centerAndDepartmentsEmployees.setDutiesEN(centerAndDepartmentsEmployeesDto.getDutiesEN());
        centerAndDepartmentsEmployees.setDutiesUZ(centerAndDepartmentsEmployeesDto.getDutiesUZ());
        centerAndDepartmentsEmployees.setDutiesRU(centerAndDepartmentsEmployeesDto.getDutiesRU());
        centerAndDepartmentsEmployees.setDutiesKR(centerAndDepartmentsEmployeesDto.getDutiesKR());
        centerAndDepartmentsEmployees.setFullName(centerAndDepartmentsEmployeesDto.getFullName());
        centerAndDepartmentsEmployees.setPhoneNumber(centerAndDepartmentsEmployeesDto.getPhoneNumber());
        centerAndDepartmentsEmployees.setEmail(centerAndDepartmentsEmployeesDto.getEmail());
        centerAndDepartmentsEmployees.setFax(centerAndDepartmentsEmployeesDto.getFax());
        centerAndDepartmentsEmployees.setTelegramlink(centerAndDepartmentsEmployeesDto.getTelegramlink());
        centerAndDepartmentsEmployees.setFacebooklink(centerAndDepartmentsEmployeesDto.getFacebooklink());
        centerAndDepartmentsEmployees.setInstagramlink(centerAndDepartmentsEmployeesDto.getInstagramlink());
        centerAndDepartmentsEmployees.setTwitterlink(centerAndDepartmentsEmployeesDto.getTwitterlink());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(centerAndDepartmentsEmployeesDto.getHashid());
        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }
        AttachmentEntity attachmentEntity = optional.get();
        centerAndDepartmentsEmployees.setImage(attachmentEntity);
        Optional<CenterAndDepartments> departmentsRepositoryById = centerAndDepartmentsRepository.findById(centerAndDepartmentsEmployeesDto.getCenterAndDepartmentId());
        if (!departmentsRepositoryById.isPresent()){
            return new ApiResponse("not found center and department", false);
        }
        centerAndDepartmentsEmployees.setCenterAndDepartments(departmentsRepositoryById.get());

        centerAndDepartmentsEmployeesRepository.save(centerAndDepartmentsEmployees);

        return new ApiResponse("add department and center success", true);
    }

    @Override
    public ApiResponse editCenterAndDepartmentsEmployees(Long id, CenterAndDepartmentsEmployeesDto centerAndDepartmentsEmployeesDto) {
        Boolean emailAndIdNot = centerAndDepartmentsEmployeesRepository.existsByEmailAndIdNot(centerAndDepartmentsEmployeesDto.getEmail(), id);
        if (emailAndIdNot){
            return new ApiResponse("already exists person", false);
        }
        Optional<CenterAndDepartmentsEmployees> optionalCenterAndDepartmentsEmployees = centerAndDepartmentsEmployeesRepository.findById(id);
        if (!optionalCenterAndDepartmentsEmployees.isPresent()){
            return new ApiResponse("not found person",false);
        }
        CenterAndDepartmentsEmployees centerAndDepartmentsEmployees = optionalCenterAndDepartmentsEmployees.get();

        centerAndDepartmentsEmployees.setBiographyEN(centerAndDepartmentsEmployeesDto.getBiographyEN());
        centerAndDepartmentsEmployees.setBiographyKR(centerAndDepartmentsEmployeesDto.getBiographyKR());
        centerAndDepartmentsEmployees.setBiographyUZ(centerAndDepartmentsEmployeesDto.getBiographyUZ());
        centerAndDepartmentsEmployees.setBiographyRU(centerAndDepartmentsEmployeesDto.getBiographyRU());
        centerAndDepartmentsEmployees.setDegree(centerAndDepartmentsEmployeesDto.getDegree());
        centerAndDepartmentsEmployees.setDutiesEN(centerAndDepartmentsEmployeesDto.getDutiesEN());
        centerAndDepartmentsEmployees.setDutiesUZ(centerAndDepartmentsEmployeesDto.getDutiesUZ());
        centerAndDepartmentsEmployees.setDutiesRU(centerAndDepartmentsEmployeesDto.getDutiesRU());
        centerAndDepartmentsEmployees.setDutiesKR(centerAndDepartmentsEmployeesDto.getDutiesKR());
        centerAndDepartmentsEmployees.setFullName(centerAndDepartmentsEmployeesDto.getFullName());
        centerAndDepartmentsEmployees.setPhoneNumber(centerAndDepartmentsEmployeesDto.getPhoneNumber());
        centerAndDepartmentsEmployees.setEmail(centerAndDepartmentsEmployeesDto.getEmail());
        centerAndDepartmentsEmployees.setFax(centerAndDepartmentsEmployeesDto.getFax());
        centerAndDepartmentsEmployees.setTelegramlink(centerAndDepartmentsEmployeesDto.getTelegramlink());
        centerAndDepartmentsEmployees.setFacebooklink(centerAndDepartmentsEmployeesDto.getFacebooklink());
        centerAndDepartmentsEmployees.setInstagramlink(centerAndDepartmentsEmployeesDto.getInstagramlink());
        centerAndDepartmentsEmployees.setTwitterlink(centerAndDepartmentsEmployeesDto.getTwitterlink());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(centerAndDepartmentsEmployeesDto.getHashid());
        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }
        AttachmentEntity attachmentEntity = optional.get();
        centerAndDepartmentsEmployees.setImage(attachmentEntity);
        Optional<CenterAndDepartments> departmentsRepositoryById = centerAndDepartmentsRepository.findById(centerAndDepartmentsEmployeesDto.getCenterAndDepartmentId());
        if (!departmentsRepositoryById.isPresent()){
            return new ApiResponse("not found center and department", false);
        }
        centerAndDepartmentsEmployees.setCenterAndDepartments(departmentsRepositoryById.get());

        centerAndDepartmentsEmployeesRepository.save(centerAndDepartmentsEmployees);

        return new ApiResponse("edit department and center success", true);
    }

    @Override
    public ApiResponse deleteCenterAndDepartmentsEmployees(Long id) {
        try{
            centerAndDepartmentsEmployeesRepository.deleteById(id);
            return new ApiResponse("delete Person",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public CenterAndDepartmentsEmployeesGet centerAndDepartmentsEmployeesById(Long id) {
        Optional<CenterAndDepartmentsEmployees> centerAndDepartmentsEmployeesRepositoryById = centerAndDepartmentsEmployeesRepository.findById(id);
        if (!centerAndDepartmentsEmployeesRepositoryById.isPresent()){
            return new CenterAndDepartmentsEmployeesGet();
        }
        CenterAndDepartmentsEmployees centerAndDepartmentsEmployeesDto = centerAndDepartmentsEmployeesRepositoryById.get();
        CenterAndDepartmentsEmployeesGet centerAndDepartmentsEmployees=new CenterAndDepartmentsEmployeesGet();
        centerAndDepartmentsEmployees.setId(centerAndDepartmentsEmployeesDto.getId());
        centerAndDepartmentsEmployees.setBiographyEN(centerAndDepartmentsEmployeesDto.getBiographyEN());
        centerAndDepartmentsEmployees.setBiographyKR(centerAndDepartmentsEmployeesDto.getBiographyKR());
        centerAndDepartmentsEmployees.setBiographyUZ(centerAndDepartmentsEmployeesDto.getBiographyUZ());
        centerAndDepartmentsEmployees.setBiographyRU(centerAndDepartmentsEmployeesDto.getBiographyRU());
        centerAndDepartmentsEmployees.setDegree(centerAndDepartmentsEmployeesDto.getDegree());
        centerAndDepartmentsEmployees.setDutiesEN(centerAndDepartmentsEmployeesDto.getDutiesEN());
        centerAndDepartmentsEmployees.setDutiesUZ(centerAndDepartmentsEmployeesDto.getDutiesUZ());
        centerAndDepartmentsEmployees.setDutiesRU(centerAndDepartmentsEmployeesDto.getDutiesRU());
        centerAndDepartmentsEmployees.setDutiesKR(centerAndDepartmentsEmployeesDto.getDutiesKR());
        centerAndDepartmentsEmployees.setFullName(centerAndDepartmentsEmployeesDto.getFullName());
        centerAndDepartmentsEmployees.setPhoneNumber(centerAndDepartmentsEmployeesDto.getPhoneNumber());
        centerAndDepartmentsEmployees.setEmail(centerAndDepartmentsEmployeesDto.getEmail());
        centerAndDepartmentsEmployees.setFax(centerAndDepartmentsEmployeesDto.getFax());
        centerAndDepartmentsEmployees.setTelegramlink(centerAndDepartmentsEmployeesDto.getTelegramlink());
        centerAndDepartmentsEmployees.setFacebooklink(centerAndDepartmentsEmployeesDto.getFacebooklink());
        centerAndDepartmentsEmployees.setInstagramlink(centerAndDepartmentsEmployeesDto.getInstagramlink());
        centerAndDepartmentsEmployees.setTwitterlink(centerAndDepartmentsEmployeesDto.getTwitterlink());
        AttachmentEntity image = centerAndDepartmentsEmployeesDto.getImage();
        AttachDto attachDto=new AttachDto();
        attachDto.setId(image.getId());
        attachDto.setHashId(image.getHashId());
        attachDto.setOrginalName(image.getOrginalName());
        attachDto.setLink(serverPath+image.getUploadFolder());
        centerAndDepartmentsEmployees.setFile(attachDto);
        CenterAndDepartments centerAndDepartments = centerAndDepartmentsEmployeesDto.getCenterAndDepartments();
        centerAndDepartmentsEmployees.setCenterAndDepartmentId(centerAndDepartments.getId());
        return centerAndDepartmentsEmployees;
    }

    @Override
    public List<CenterAndDepartmentsEmployeesGet> allCenterAndDepartmentsEmployees() {
        List<CenterAndDepartmentsEmployees> employeesRepositoryAll = centerAndDepartmentsEmployeesRepository.findAll();
        List<CenterAndDepartmentsEmployeesGet> centerAndDepartmentsEmployeesGetList=new ArrayList<>();
        for (CenterAndDepartmentsEmployees centerAndDepartmentsEmployeesDto : employeesRepositoryAll) {
            CenterAndDepartmentsEmployeesGet centerAndDepartmentsEmployees=new CenterAndDepartmentsEmployeesGet();
            centerAndDepartmentsEmployees.setId(centerAndDepartmentsEmployeesDto.getId());
            centerAndDepartmentsEmployees.setBiographyEN(centerAndDepartmentsEmployeesDto.getBiographyEN());
            centerAndDepartmentsEmployees.setBiographyKR(centerAndDepartmentsEmployeesDto.getBiographyKR());
            centerAndDepartmentsEmployees.setBiographyUZ(centerAndDepartmentsEmployeesDto.getBiographyUZ());
            centerAndDepartmentsEmployees.setBiographyRU(centerAndDepartmentsEmployeesDto.getBiographyRU());
            centerAndDepartmentsEmployees.setDegree(centerAndDepartmentsEmployeesDto.getDegree());
            centerAndDepartmentsEmployees.setDutiesEN(centerAndDepartmentsEmployeesDto.getDutiesEN());
            centerAndDepartmentsEmployees.setDutiesUZ(centerAndDepartmentsEmployeesDto.getDutiesUZ());
            centerAndDepartmentsEmployees.setDutiesRU(centerAndDepartmentsEmployeesDto.getDutiesRU());
            centerAndDepartmentsEmployees.setDutiesKR(centerAndDepartmentsEmployeesDto.getDutiesKR());
            centerAndDepartmentsEmployees.setFullName(centerAndDepartmentsEmployeesDto.getFullName());
            centerAndDepartmentsEmployees.setPhoneNumber(centerAndDepartmentsEmployeesDto.getPhoneNumber());
            centerAndDepartmentsEmployees.setEmail(centerAndDepartmentsEmployeesDto.getEmail());
            centerAndDepartmentsEmployees.setFax(centerAndDepartmentsEmployeesDto.getFax());
            centerAndDepartmentsEmployees.setTelegramlink(centerAndDepartmentsEmployeesDto.getTelegramlink());
            centerAndDepartmentsEmployees.setFacebooklink(centerAndDepartmentsEmployeesDto.getFacebooklink());
            centerAndDepartmentsEmployees.setInstagramlink(centerAndDepartmentsEmployeesDto.getInstagramlink());
            centerAndDepartmentsEmployees.setTwitterlink(centerAndDepartmentsEmployeesDto.getTwitterlink());
            AttachmentEntity image = centerAndDepartmentsEmployeesDto.getImage();
            AttachDto attachDto=new AttachDto();
            attachDto.setId(image.getId());
            attachDto.setHashId(image.getHashId());
            attachDto.setOrginalName(image.getOrginalName());
            attachDto.setLink(serverPath+image.getUploadFolder());
            centerAndDepartmentsEmployees.setFile(attachDto);
            CenterAndDepartments centerAndDepartments = centerAndDepartmentsEmployeesDto.getCenterAndDepartments();
            centerAndDepartmentsEmployees.setCenterAndDepartmentId(centerAndDepartments.getId());
            centerAndDepartmentsEmployeesGetList.add(centerAndDepartmentsEmployees);
        }
        return centerAndDepartmentsEmployeesGetList;
    }
}
