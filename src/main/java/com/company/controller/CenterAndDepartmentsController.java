package com.company.controller;

import com.company.dto.CenterAndDepartmentsDtoGet;
import com.company.entity.Facultys;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsDto;
import com.company.payload.FacultyDto;
import com.company.service.CenterAndDepartmentsService;
import com.company.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CenterAndDepartmentsController {
    @Autowired
    private CenterAndDepartmentsService centerAndDepartmentsService;

    @PostMapping("/user/addCenterAndDepartment")
    public ResponseEntity<?> addCenterAndDepartment(@Valid @RequestBody CenterAndDepartmentsDto centerAndDepartmentsDto){
        ApiResponse apiResponse=centerAndDepartmentsService.addCenterAndDepartment(centerAndDepartmentsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editCenterAndDepartment/{id}")
    public HttpEntity<?> editCenterAndDepartment(@Valid @PathVariable Long id, @RequestBody CenterAndDepartmentsDto centerAndDepartmentsDto){
        ApiResponse apiResponse=centerAndDepartmentsService.editCenterAndDepartment(id,centerAndDepartmentsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteCenterAndDepartment/{id}")
    public HttpEntity<?> deleteCenterAndDepartment(@PathVariable Long id){
        ApiResponse apiResponse=centerAndDepartmentsService.deleteCenterAndDepartment(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/CenterAndDepartmentById/{id}")
    public HttpEntity<?> CenterAndDepartmentById(@PathVariable Long id){
        CenterAndDepartmentsDtoGet centerAndDepartmentsDtoGet=centerAndDepartmentsService.сenterAndDepartmentById(id);
        return ResponseEntity.ok(centerAndDepartmentsDtoGet);
    }


    @GetMapping("/public/allCenterAndDepartments")
    public HttpEntity<?> allCenterAndDepartments(){
        List<CenterAndDepartmentsDtoGet> getAll=centerAndDepartmentsService.allCenterAndDepartments();
        return ResponseEntity.ok(getAll);
    }
}
