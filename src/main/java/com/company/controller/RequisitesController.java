package com.company.controller;

import com.company.entity.NewsDay;
import com.company.entity.Requisites;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.payload.RequisitesDto;
import com.company.service.NewsDayService;
import com.company.service.RequisitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RequisitesController {

    @Autowired
    private RequisitesService requisitesService;

    @PostMapping("/admin/Requisitesave")
    public ResponseEntity<?> Requisitesave(@Valid @RequestBody RequisitesDto requisitesDto){
        ApiResponse apiResponse=requisitesService.Requisitesave(requisitesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/user/editRequisite/{id}")
    public HttpEntity<?> editRequisite(@Valid @PathVariable Long id, @RequestBody RequisitesDto requisitesDto){
        ApiResponse apiResponse=requisitesService.editRequisite(id,requisitesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/user/deleteRequisite/{id}")
    public HttpEntity<?> deleteRequisite(@PathVariable Long id){
        ApiResponse apiResponse=requisitesService.deleteRequisite(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/public/RequisiteById/{id}")
    public HttpEntity<?> requisiteById(@PathVariable Long id){
        Requisites requisites=requisitesService.requisiteById(id);
        return ResponseEntity.ok(requisites);
    }
}
