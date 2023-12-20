package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.Category;
import com.company.entity.Departments;
import com.company.entity.Employees;
import com.company.entity.enums.LeadershipStatus;
import com.company.payload.ApiResponse;
import com.company.payload.EmployeesDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.CategoryRepository;
import com.company.repository.DepartmentsRepository;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ApiResponse addEmployee(EmployeesDto employeesDto) {
        Boolean existsByEmail = employeeRepository.existsByEmail(employeesDto.getEmail());
        if (existsByEmail){
            return new ApiResponse("already exists email", false);
        }

        Employees employees=new Employees();

        employees.setDegree(employeesDto.getDegree());
        employees.setBiographyKR(employeesDto.getBiographyKR());
        employees.setBiographyEN(employeesDto.getBiographyEN());
        employees.setBiographyRU(employeesDto.getBiographyRU());
        employees.setBiographyUZ(employeesDto.getBiographyUZ());
        employees.setDutiesEN(employeesDto.getDutiesEN());
        employees.setDutiesKR(employeesDto.getDutiesKR());
        employees.setDutiesUZ(employeesDto.getDutiesUZ());
        employees.setDutiesRU(employeesDto.getDutiesRU());
        employees.setEmail(employeesDto.getEmail());
        employees.setFax(employeesDto.getFax());
        employees.setFacebooklink(employeesDto.getFacebooklink());
        employees.setInstagramlink(employeesDto.getInstagramlink());
        employees.setTelegramlink(employeesDto.getTelegramlink());
        employees.setTwitterlink(employeesDto.getTwitterlink());
        employees.setFullName(employeesDto.getFullName());
        employees.setPhoneNumber(employeesDto.getPhoneNumber());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(employeesDto.getHashid());
        if (!optional.isPresent()){
            return new ApiResponse("not found image",false);
        }
        employees.setImage(optional.get());

        Optional<Departments> optionalDepartments = departmentsRepository.findById(employeesDto.getDepartmentid());
        if (!optionalDepartments.isPresent()){
            return new ApiResponse("not found department", false);
        }
        employees.setDepartments(optionalDepartments.get());
        Optional<Category> categoryOptional = categoryRepository.findById(employeesDto.getCategoryId());
        if (categoryOptional.isPresent()){
            employees.setCategory(categoryOptional.get());
        }
        else{
            employees.setCategory(null);
        }

        employeeRepository.save(employees);
        return new ApiResponse("add employee success", true);
    }

    @Override
    public ApiResponse editEmployee(Long id, EmployeesDto employeesDto) {
        Boolean emailAndIdNot = employeeRepository.existsByEmailAndIdNot(employeesDto.getEmail(), id);
        if (emailAndIdNot){
            return new ApiResponse("Already exists person", false);
        }
        Optional<Employees> repositoryById = employeeRepository.findById(id);
        if (!repositoryById.isPresent()){
            return new ApiResponse("not found employee", false);
        }

        Employees employees = repositoryById.get();

        employees.setDegree(employeesDto.getDegree());
        employees.setBiographyKR(employeesDto.getBiographyKR());
        employees.setBiographyEN(employeesDto.getBiographyEN());
        employees.setBiographyRU(employeesDto.getBiographyRU());
        employees.setBiographyUZ(employeesDto.getBiographyUZ());
        employees.setDutiesEN(employeesDto.getDutiesEN());
        employees.setDutiesKR(employeesDto.getDutiesKR());
        employees.setDutiesUZ(employeesDto.getDutiesUZ());
        employees.setDutiesRU(employeesDto.getDutiesRU());
        employees.setEmail(employeesDto.getEmail());
        employees.setFax(employeesDto.getFax());
        employees.setFacebooklink(employeesDto.getFacebooklink());
        employees.setInstagramlink(employeesDto.getInstagramlink());
        employees.setTelegramlink(employeesDto.getTelegramlink());
        employees.setTwitterlink(employeesDto.getTwitterlink());
        employees.setFullName(employeesDto.getFullName());
        employees.setPhoneNumber(employeesDto.getPhoneNumber());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(employeesDto.getHashid());
        if (!optional.isPresent()){
            return new ApiResponse("not found image",false);
        }
        employees.setImage(optional.get());

        Optional<Departments> optionalDepartments = departmentsRepository.findById(employeesDto.getDepartmentid());
        if (!optionalDepartments.isPresent()){
            return new ApiResponse("not found department", false);
        }

        employees.setDepartments(optionalDepartments.get());

        Optional<Category> categoryOptional = categoryRepository.findById(employeesDto.getCategoryId());
        if (categoryOptional.isPresent()){
            employees.setCategory(categoryOptional.get());
        }
        else{
            employees.setCategory(null);
        }
        employeeRepository.save(employees);

        return new ApiResponse("edit employee success", true);
    }

    @Override
    public ApiResponse deleteEmployee(Long id) {
        try{
            employeeRepository.deleteById(id);
            return new ApiResponse("delete employee",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Employees employeeByid(Long id) {
        return employeeRepository.findById(id).orElse(new Employees());
    }

    @Override
    public List<Employees> allEmployeeByDepartmentId(Long id) {
        return employeeRepository.findAllByDepartments_id(id);
    }

}
