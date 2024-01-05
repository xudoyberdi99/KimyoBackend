package com.company.controller;

import com.company.dto.CenterAndDepartmentsDtoGet;
import com.company.dto.CenterAndDepartmentsEmployeesGet;
import com.company.payload.ApiResponse;
import com.company.payload.CenterAndDepartmentsDto;
import com.company.payload.CenterAndDepartmentsEmployeesDto;
import com.company.service.CenterAndDepartmentsEmployeesService;
import com.company.service.CenterAndDepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CenterAndDepartmentsEmployeesController {
    @Autowired
    private CenterAndDepartmentsEmployeesService centerAndDepartmentsEmployeesService;

    @PostMapping("/user/addCenterAndDepartmentsEmployees")
    public ResponseEntity<?> addCenterAndDepartmentsEmployees(@Valid @RequestBody CenterAndDepartmentsEmployeesDto centerAndDepartmentsEmployeesDto){
        ApiResponse apiResponse=centerAndDepartmentsEmployeesService.addCenterAndDepartmentsEmployees(centerAndDepartmentsEmployeesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editCenterAndDepartmentsEmployees/{id}")
    public HttpEntity<?> editCenterAndDepartmentsEmployees(@Valid @PathVariable Long id, @RequestBody CenterAndDepartmentsEmployeesDto centerAndDepartmentsEmployeesDto){
        ApiResponse apiResponse=centerAndDepartmentsEmployeesService.editCenterAndDepartmentsEmployees(id,centerAndDepartmentsEmployeesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteCenterAndDepartmentsEmployees/{id}")
    public HttpEntity<?> deleteCenterAndDepartmentsEmployees(@PathVariable Long id){
        ApiResponse apiResponse=centerAndDepartmentsEmployeesService.deleteCenterAndDepartmentsEmployees(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/CenterAndDepartmentsEmployeesById/{id}")
    public HttpEntity<?> centerAndDepartmentsEmployeesById(@PathVariable Long id){
        CenterAndDepartmentsEmployeesGet centerAndDepartmentsDtoGet=centerAndDepartmentsEmployeesService.centerAndDepartmentsEmployeesById(id);
        return ResponseEntity.ok(centerAndDepartmentsDtoGet);
    }


    @GetMapping("/public/allCenterAndDepartmentsEmployees")
    public HttpEntity<?> allCenterAndDepartmentsEmployees(){
        List<CenterAndDepartmentsEmployeesGet> getAll=centerAndDepartmentsEmployeesService.allCenterAndDepartmentsEmployees();
        return ResponseEntity.ok(getAll);
    }
}
