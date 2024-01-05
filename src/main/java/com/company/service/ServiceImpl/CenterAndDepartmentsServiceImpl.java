package com.company.service.ServiceImpl;

import com.company.dto.CenterAndDepartmentsDtoGet;
import com.company.entity.CenterAndDepartments;
import com.company.entity.CenterAndDepartmentsEmployees;
import com.company.entity.Facultys;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsDto;
import com.company.repository.CenterAndDepartmentsEmployeesRepository;
import com.company.repository.CenterAndDepartmentsRepository;
import com.company.service.CenterAndDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
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

        List<CenterAndDepartmentsEmployees> allByCenterAndDepartments = centerAndDepartmentsEmployeesRepository.findAllByCenterAndDepartments(centerAndDepartmentsDto.getId());
        centerAndDepartments.setEmployees(allByCenterAndDepartments);

        return centerAndDepartments;
    }

    @Override
    public List<CenterAndDepartmentsDtoGet> allCenterAndDepartments() {
        List<CenterAndDepartments> allcenteranddepartments = centerAndDepartmentsRepository.findAll();
        List<CenterAndDepartmentsDtoGet> departmentsDtoGetList=new ArrayList<>();
        for (CenterAndDepartments centerAndDepartmentsDto : allcenteranddepartments) {
            CenterAndDepartmentsDtoGet centerAndDepartments=new CenterAndDepartmentsDtoGet();

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

            List<CenterAndDepartmentsEmployees> allByCenterAndDepartments = centerAndDepartmentsEmployeesRepository.findAllByCenterAndDepartments(centerAndDepartmentsDto.getId());
            centerAndDepartments.setEmployees(allByCenterAndDepartments);
            departmentsDtoGetList.add(centerAndDepartments);
        }
        return departmentsDtoGetList;
    }
}
