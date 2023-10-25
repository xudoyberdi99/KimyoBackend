package com.company.controller;

import com.company.entity.News;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.payload.NewsDto;
import com.company.service.NewsDayService;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("/Newssave")
    public ResponseEntity<?> addNews(@Valid @RequestBody NewsDto newsDto){
        ApiResponse apiResponse=newsService.saveNews(newsDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }
    @PutMapping("/editNews/{id}")
    public HttpEntity<?> editNews(@Valid @PathVariable Long id, @RequestBody NewsDto newsDto){
        ApiResponse apiResponse=newsService.editNews(id,newsDto);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }
    @DeleteMapping("/deleteNews/{id}")
    public HttpEntity<?> deleteNews(@PathVariable Long id){
        ApiResponse apiResponse=newsService.deleteNews(id);
        return ResponseEntity.status(apiResponse.isSucces()?200:409).body(apiResponse);
    }
    @GetMapping("/newsById/{id}")
    public HttpEntity<?> newsById(@PathVariable Long id){
       News news=newsService.newsById(id);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/allnews")
    public HttpEntity<?> Allnews(){
        List<News> news=newsService.Allnews();
        return ResponseEntity.ok(news);
    }
}
