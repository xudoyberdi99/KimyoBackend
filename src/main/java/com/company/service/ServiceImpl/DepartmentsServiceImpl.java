package com.company.service.ServiceImpl;

import com.company.entity.Category;
import com.company.entity.Departments;
import com.company.entity.Facultys;
import com.company.entity.Leadership;
import com.company.payload.ApiResponse;
import com.company.payload.DepartmentsDto;
import com.company.repository.*;
import com.company.service.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {
    @Autowired
    private DepartmentsRepository departmentsRepository;
    @Autowired
    private LeadershipRepository leadershipRepository;
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public ApiResponse addDepartment(DepartmentsDto departmentsDto) {
        Departments departments=new Departments();

        departments.setNameEN(departmentsDto.getNameEN());
        departments.setNameUZ(departmentsDto.getNameUZ());
        departments.setNameRU(departmentsDto.getNameRU());
        departments.setNameKR(departmentsDto.getNameKR());
        departments.setDescriptionKR(departmentsDto.getDescriptionKR());
        departments.setDescriptionEN(departmentsDto.getDescriptionEN());
        departments.setDescriptionRU(departmentsDto.getDescriptionRU());
        departments.setDescriptionUZ(departmentsDto.getDescriptionUZ());
        Optional<Leadership> optionalLeadership = leadershipRepository.findById(departmentsDto.getLeadershipId());
        if (!optionalLeadership.isPresent()){
            return new ApiResponse("not found leadership", false);
        }
        departments.setLeadership(optionalLeadership.get());
        Optional<Facultys> facultyRepositoryById = facultyRepository.findById(departmentsDto.getFacultyId());
        if (!facultyRepositoryById.isPresent()){
            return new ApiResponse("not found faculty", false);
        }
        departments.setFacultys(facultyRepositoryById.get());
        departmentsRepository.save(departments);
        return new ApiResponse("add Department success", true);
    }

    @Override
    public ApiResponse editDepartment(Long id, DepartmentsDto departmentsDto) {
        Optional<Departments> optionalDepartments = departmentsRepository.findById(id);
        if (!optionalDepartments.isPresent()){
            return new ApiResponse("not found department",false);
        }

        Departments departments = optionalDepartments.get();
        departments.setNameEN(departmentsDto.getNameEN());
        departments.setNameUZ(departmentsDto.getNameUZ());
        departments.setNameRU(departmentsDto.getNameRU());
        departments.setNameKR(departmentsDto.getNameKR());
        departments.setDescriptionKR(departmentsDto.getDescriptionKR());
        departments.setDescriptionEN(departmentsDto.getDescriptionEN());
        departments.setDescriptionRU(departmentsDto.getDescriptionRU());
        departments.setDescriptionUZ(departmentsDto.getDescriptionUZ());
        Optional<Leadership> optionalLeadership = leadershipRepository.findById(departmentsDto.getLeadershipId());
        if (!optionalLeadership.isPresent()){
            return new ApiResponse("not found leadership", false);
        }
        departments.setLeadership(optionalLeadership.get());
        Optional<Facultys> facultyRepositoryById = facultyRepository.findById(departmentsDto.getFacultyId());
        if (!facultyRepositoryById.isPresent()){
            return new ApiResponse("not found faculty", false);
        }
        departments.setFacultys(facultyRepositoryById.get());
        departmentsRepository.save(departments);
        return new ApiResponse("add Department success", true);
    }

    @Override
    public ApiResponse deleteDepartment(Long id) {
        try{
            departmentsRepository.deleteById(id);
            return new ApiResponse("delete department",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Departments departmentById(Long id) {
        return departmentsRepository.findById(id).orElse(new Departments());
    }

    @Override
    public List<Departments> allDepartments() {
        return departmentsRepository.findAll();
    }

    @Override
    public List<Departments> allDepartmentsByFacultyId(Long facultyid) {
        return departmentsRepository.allDepartmentsByFacultyId(facultyid);
    }
}
