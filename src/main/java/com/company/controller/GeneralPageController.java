package com.company.controller;

import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.ConferencesDto;
import com.company.payload.GeneralPageDto;
import com.company.service.ConferencesService;
import com.company.service.GeneralPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class GeneralPageController {

    @Autowired
    private GeneralPageService generalPageService;

    @PostMapping("/addgeneralpage")
    public ResponseEntity<?> addgeneralpage(@Valid @RequestBody GeneralPageDto generalPageDto){
        ApiResponse apiResponse=generalPageService.addgeneralpage(generalPageDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/editGeneralPage/{id}")
    public HttpEntity<?> editGeneralPage(@Valid @PathVariable Long id, @RequestBody GeneralPageDto generalPageDto){
        ApiResponse apiResponse=generalPageService.editGeneralPage(id,generalPageDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/generalpageDelete/{id}")
    public HttpEntity<?> generalpageDelete(@PathVariable Long id){
        ApiResponse apiResponse=generalPageService.generalpageDelete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/generalPageGetById/{id}")
    public HttpEntity<?> generalPageGetById(@PathVariable Long id){
        Conferences conferences=generalPageService.generalPageGetById(id);
        return ResponseEntity.ok(conferences);
    }
}
