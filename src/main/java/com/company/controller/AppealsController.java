package com.company.controller;

import com.company.entity.Appeals;
import com.company.entity.News;
import com.company.payload.ApiResponse;
import com.company.payload.AppealsDto;
import com.company.payload.NewsDto;
import com.company.service.AppealsService;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AppealsController {
    @Autowired
    private AppealsService appealsService;


    @PostMapping("/public/appealAdd")
    public ResponseEntity<?> appealAdd(@Valid @RequestBody AppealsDto appealsDto){
        ApiResponse apiResponse=appealsService.appealAdd(appealsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteAppeals/{id}")
    public HttpEntity<?> deleteAppeals(@PathVariable Long id){
        ApiResponse apiResponse=appealsService.deleteAppeals(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/user/appealsById/{id}")
    public HttpEntity<?> appealsById(@PathVariable Long id){
        Appeals  appeals=appealsService.appealsById(id);
        return ResponseEntity.ok(appeals);
    }

    @GetMapping("/user/allAppeals")
    public HttpEntity<?> Allappeals(int page, int size){
        Page<Appeals> appeals=appealsService.Allappeals(page,size);
        return ResponseEntity.ok(appeals);
    }
}
