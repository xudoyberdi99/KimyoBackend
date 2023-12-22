package com.company.controller;

import com.company.entity.Appeals;
import com.company.entity.RectorToAppeals;
import com.company.payload.ApiResponse;
import com.company.payload.AppealsDto;
import com.company.payload.RectorToAppealsDto;
import com.company.service.AppealsService;
import com.company.service.RectorToAppealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RectorToAppealsController {

    @Autowired
    private RectorToAppealsService rectorToAppealsService;


    @PostMapping("/public/appealtorectorAdd")
    public ResponseEntity<?> appealAdd(@Valid @RequestBody RectorToAppealsDto rectorToAppealsDto){
        ApiResponse apiResponse=rectorToAppealsService.appealAdd(rectorToAppealsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteAppealstoRector/{id}")
    public HttpEntity<?> deleteAppeals(@PathVariable Long id){
        ApiResponse apiResponse=rectorToAppealsService.deleteAppeals(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/user/appealsTorectorById/{id}")
    public HttpEntity<?> appealsById(@PathVariable Long id){
        RectorToAppeals rectorToAppeals=rectorToAppealsService.appealsById(id);
        return ResponseEntity.ok(rectorToAppeals);
    }

    @GetMapping("/user/allAppealstoRectors")
    public HttpEntity<?> Allappeals(int page, int size){
        Page<RectorToAppeals> rectorToAppeals=rectorToAppealsService.Allappeals(page,size);
        return ResponseEntity.ok(rectorToAppeals);
    }
}
