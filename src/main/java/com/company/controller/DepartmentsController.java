package com.company.controller;

import com.company.entity.Departments;
import com.company.entity.Leadership;
import com.company.payload.ApiResponse;
import com.company.payload.DepartmentsDto;
import com.company.payload.LeadershipDto;
import com.company.service.DepartmentsService;
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
public class DepartmentsController {
    @Autowired
    private DepartmentsService departmentsService;

    @PostMapping("/addDepartment")
    public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentsDto departmentsDto){
        ApiResponse apiResponse=departmentsService.addDepartment(departmentsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/editDepartment/{id}")
    public HttpEntity<?> editDepartment(@Valid @PathVariable Long id, @RequestBody DepartmentsDto departmentsDto){
        ApiResponse apiResponse=departmentsService.editDepartment(id,departmentsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public HttpEntity<?> deleteDepartment(@PathVariable Long id){
        ApiResponse apiResponse=departmentsService.deleteDepartment(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/departmentById/{id}")
    public HttpEntity<?> departmentById(@PathVariable Long id){
        Departments departments=departmentsService.departmentById(id);
        return ResponseEntity.ok(departments);
    }


    @GetMapping("/allDepartments")
    public HttpEntity<?> allDepartments(){
        List<Departments> getalldepartments=departmentsService.allDepartments();
        return ResponseEntity.ok(getalldepartments);
    }

}
