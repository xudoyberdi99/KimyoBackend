package com.company.controller;

import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.service.NewsDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class NewsDayController {


    @Autowired
    private NewsDayService newsDayService;

    @PostMapping("/save")
    public ResponseEntity<?> addNewsDay(@Valid @RequestBody NewsDayDto newsDayDto){
        ApiResponse apiResponse=newsDayService.saveNews(newsDayDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }
    @PutMapping("/edit/{id}")
    public HttpEntity<?> editNews(@Valid @PathVariable Long id, @RequestBody NewsDayDto newsDayDto){
        ApiResponse apiResponse=newsDayService.editNews(id,newsDayDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteNews(@PathVariable Long id){
        ApiResponse apiResponse=newsDayService.deleteNews(id);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }
    @GetMapping("/newsById/{id}")
    public HttpEntity<?> newsById(@PathVariable Long id){
        NewsDay news=newsDayService.newsById(id);
        return ResponseEntity.ok(news);
    }
}
