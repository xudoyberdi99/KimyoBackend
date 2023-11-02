package com.company.controller;

import com.company.entity.GeneralInformation;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralInformationDto;
import com.company.payload.NewsDayDto;
import com.company.service.GeneralInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class GeneralInformationController {
    @Autowired
    private GeneralInformationService generalInformationService;

    @PostMapping("/GeneralInformatsave")
    public ResponseEntity<?> addGeneralInformat(@Valid @RequestBody GeneralInformationDto generalInformationDto){
        ApiResponse apiResponse=generalInformationService.saveGeneralInformat(generalInformationDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/editGeneralInformat/{id}")
    public HttpEntity<?> editGeneralInformat(@Valid @PathVariable Long id, @RequestBody GeneralInformationDto generalInformationDto){
        ApiResponse apiResponse=generalInformationService.editGeneralInformat(id,generalInformationDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/deleteGeneralInformat/{id}")
    public HttpEntity<?> deleteGeneralInformat(@PathVariable Long id){
        ApiResponse apiResponse=generalInformationService.deleteGeneralInformat(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/GeneralInformatById/{id}")
    public HttpEntity<?> GeneralInformatById(@PathVariable Long id){
        GeneralInformation generalInformation=generalInformationService.GeneralInformatById(id);
        return ResponseEntity.ok(generalInformation);
    }
}
