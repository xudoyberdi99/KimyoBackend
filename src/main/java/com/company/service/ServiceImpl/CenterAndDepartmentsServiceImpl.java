package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.CenterAndDepartmentsDtoGet;
import com.company.dto.CenterAndDepartmentsEmployeesGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.CenterAndDepartments;
import com.company.entity.CenterAndDepartmentsEmployees;
import com.company.entity.Facultys;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsDto;
import com.company.payload.CenterAndDepartmentsEmployeesDto;
import com.company.repository.CenterAndDepartmentsEmployeesRepository;
import com.company.repository.CenterAndDepartmentsRepository;
import com.company.service.CenterAndDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CenterAndDepartmentsServiceImpl implements CenterAndDepartmentsService {

    @Autowired
    private CenterAndDepartmentsRepository centerAndDepartmentsRepository;
    @Autowired
    private CenterAndDepartmentsEmployeesRepository centerAndDepartmentsEmployeesRepository;

    @Value("${upload.server}")
    private String serverPath;

    @Override
    public ApiResponse addCenterAndDepartment(CenterAndDepartmentsDto centerAndDepartmentsDto) {
        CenterAndDepartments centerAndDepartments=new CenterAndDepartments();

        centerAndDepartments.setDescriptionEN(centerAndDepartmentsDto.getDescriptionEN());
        centerAndDepartments.setDescriptionRU(centerAndDepartmentsDto.getDescriptionRU());
        centerAndDepartments.setDescriptionKR(centerAndDepartmentsDto.getDescriptionKR());
        centerAndDepartments.setDescriptionUZ(centerAndDepartmentsDto.getDescriptionUZ());

        centerAndDepartments.setNameEN(centerAndDepartmentsDto.getNameEN());
        centerAndDepartments.setNameKR(centerAndDepartmentsDto.getNameKR());
        centerAndDepartments.setNameUZ(centerAndDepartmentsDto.getNameUZ());
        centerAndDepartments.setNameRU(centerAndDepartmentsDto.getNameRU());

        centerAndDepartments.setTitleEN(centerAndDepartmentsDto.getTitleEN());
        centerAndDepartments.setTitleUZ(centerAndDepartmentsDto.getTitleUZ());
        centerAndDepartments.setTitleRU(centerAndDepartmentsDto.getTitleRU());
        centerAndDepartments.setTitleKR(centerAndDepartmentsDto.getTitleKR());

        centerAndDepartmentsRepository.save(centerAndDepartments);

        return new ApiResponse("add center departments success", true);
    }

    @Override
    public ApiResponse editCenterAndDepartment(Long id, CenterAndDepartmentsDto centerAndDepartmentsDto) {

        Optional<CenterAndDepartments> departmentsRepositoryById = centerAndDepartmentsRepository.findById(id);
        if (!departmentsRepositoryById.isPresent()){
            return new ApiResponse("not found ",false);
        }
        CenterAndDepartments centerAndDepartments = departmentsRepositoryById.get();

        centerAndDepartments.setDescriptionEN(centerAndDepartmentsDto.getDescriptionEN());
        centerAndDepartments.setDescriptionRU(centerAndDepartmentsDto.getDescriptionRU());
        centerAndDepartments.setDescriptionKR(centerAndDepartmentsDto.getDescriptionKR());
        centerAndDepartments.setDescriptionUZ(centerAndDepartmentsDto.getDescriptionUZ());

        centerAndDepartments.setNameEN(centerAndDepartmentsDto.getNameEN());
        centerAndDepartments.setNameKR(centerAndDepartmentsDto.getNameKR());
        centerAndDepartments.setNameUZ(centerAndDepartmentsDto.getNameUZ());
        centerAndDepartments.setNameRU(centerAndDepartmentsDto.getNameRU());

        centerAndDepartments.setTitleEN(centerAndDepartmentsDto.getTitleEN());
        centerAndDepartments.setTitleUZ(centerAndDepartmentsDto.getTitleUZ());
        centerAndDepartments.setTitleRU(centerAndDepartmentsDto.getTitleRU());
        centerAndDepartments.setTitleKR(centerAndDepartmentsDto.getTitleKR());

        centerAndDepartmentsRepository.save(centerAndDepartments);
        return new ApiResponse("edit center and departments success", true);
    }

    @Override
    public ApiResponse deleteCenterAndDepartment(Long id) {
        try{
            centerAndDepartmentsRepository.deleteById(id);
            return new ApiResponse("delete center and department",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public CenterAndDepartmentsDtoGet сenterAndDepartmentById(Long id) {
        Optional<CenterAndDepartments> departmentsRepositoryById = centerAndDepartmentsRepository.findById(id);
        if (!departmentsRepositoryById.isPresent()){
            return new CenterAndDepartmentsDtoGet();
        }
        CenterAndDepartments centerAndDepartmentsDto = departmentsRepositoryById.get();

        CenterAndDepartmentsDtoGet centerAndDepartments=new CenterAndDepartmentsDtoGet();
        centerAndDepartments.setId(centerAndDepartmentsDto.getId());
        centerAndDepartments.setDescriptionEN(centerAndDepartmentsDto.getDescriptionEN());
        centerAndDepartments.setDescriptionRU(centerAndDepartmentsDto.getDescriptionRU());
        centerAndDepartments.setDescriptionKR(centerAndDepartmentsDto.getDescriptionKR());
        centerAndDepartments.setDescriptionUZ(centerAndDepartmentsDto.getDescriptionUZ());

        centerAndDepartments.setNameEN(centerAndDepartmentsDto.getNameEN());
        centerAndDepartments.setNameKR(centerAndDepartmentsDto.getNameKR());
        centerAndDepartments.setNameUZ(centerAndDepartmentsDto.getNameUZ());
        centerAndDepartments.setNameRU(centerAndDepartmentsDto.getNameRU());

        centerAndDepartments.setTitleEN(centerAndDepartmentsDto.getTitleEN());
        centerAndDepartments.setTitleUZ(centerAndDepartmentsDto.getTitleUZ());
        centerAndDepartments.setTitleRU(centerAndDepartmentsDto.getTitleRU());
        centerAndDepartments.setTitleKR(centerAndDepartmentsDto.getTitleKR());

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
            centerAndDepartmentsEmployees.setCenterAndDepartmentId(id);

            centerAndDepartmentsEmployeesGetList.add(centerAndDepartmentsEmployees);
        }
        centerAndDepartments.setEmployees(centerAndDepartmentsEmployeesGetList);

        return centerAndDepartments;
    }

    @Override
    public List<CenterAndDepartmentsDtoGet> allCenterAndDepartments() {
        List<CenterAndDepartments> allcenteranddepartments = centerAndDepartmentsRepository.findAll();
        List<CenterAndDepartmentsDtoGet> departmentsDtoGetList=new ArrayList<>();
        for (CenterAndDepartments centerAndDepartmentsDto : allcenteranddepartments) {
            CenterAndDepartmentsDtoGet centerAndDepartments=new CenterAndDepartmentsDtoGet();
            centerAndDepartments.setId(centerAndDepartmentsDto.getId());
            centerAndDepartments.setDescriptionEN(centerAndDepartmentsDto.getDescriptionEN());
            centerAndDepartments.setDescriptionRU(centerAndDepartmentsDto.getDescriptionRU());
            centerAndDepartments.setDescriptionKR(centerAndDepartmentsDto.getDescriptionKR());
            centerAndDepartments.setDescriptionUZ(centerAndDepartmentsDto.getDescriptionUZ());

            centerAndDepartments.setNameEN(centerAndDepartmentsDto.getNameEN());
            centerAndDepartments.setNameKR(centerAndDepartmentsDto.getNameKR());
            centerAndDepartments.setNameUZ(centerAndDepartmentsDto.getNameUZ());
            centerAndDepartments.setNameRU(centerAndDepartmentsDto.getNameRU());

            centerAndDepartments.setTitleEN(centerAndDepartmentsDto.getTitleEN());
            centerAndDepartments.setTitleUZ(centerAndDepartmentsDto.getTitleUZ());
            centerAndDepartments.setTitleRU(centerAndDepartmentsDto.getTitleRU());
            centerAndDepartments.setTitleKR(centerAndDepartmentsDto.getTitleKR());

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
                centerAndDepartmentsEmployees.setCenterAndDepartmentId(centerAndDepartmentsDto.getId());

                centerAndDepartmentsEmployeesGetList.add(centerAndDepartmentsEmployees);
            }
            centerAndDepartments.setEmployees(centerAndDepartmentsEmployeesGetList);

            departmentsDtoGetList.add(centerAndDepartments);
        }
        return departmentsDtoGetList;
    }
}
