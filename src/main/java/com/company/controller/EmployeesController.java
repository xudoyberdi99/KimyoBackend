package com.company.controller;

import com.company.entity.Employees;
import com.company.entity.Leadership;
import com.company.payload.ApiResponse;
import com.company.payload.EmployeesDto;
import com.company.payload.LeadershipDto;
import com.company.service.EmployeesService;
import com.company.service.LeadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/user/addEmployee")
    public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeesDto employeesDto){
        ApiResponse apiResponse=employeesService.addEmployee(employeesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editEmployee/{id}")
    public HttpEntity<?> editEmployee(@Valid @PathVariable Long id, @RequestBody EmployeesDto employeesDto){
        ApiResponse apiResponse=employeesService.editEmployee(id,employeesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteEmployee/{id}")
    public HttpEntity<?> deleteEmployee(@PathVariable Long id){
        ApiResponse apiResponse=employeesService.deleteEmployee(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/employeeByid/{id}")
    public HttpEntity<?> employeeByid(@PathVariable Long id){
        Employees employees=employeesService.employeeByid(id);
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/public/allEmployeeByDepartmentId/{id}")
    public HttpEntity<?> allEmployeeByDepartmentId(@PathVariable Long id){
        List<Employees> employees=employeesService.allEmployeeByDepartmentId(id);
        return ResponseEntity.ok(employees);
    }


}
