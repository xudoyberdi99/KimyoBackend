package com.company.controller;

import com.company.dto.NewsGetDto;
import com.company.entity.News;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDto;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @PostMapping("/user/Newssave")
    public ResponseEntity<?> addNews(@Valid @RequestBody NewsDto newsDto){
        ApiResponse apiResponse=newsService.saveNews(newsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/user/editNews/{id}")
    public HttpEntity<?> editNews(@Valid @PathVariable Long id, @RequestBody NewsDto newsDto){
        ApiResponse apiResponse=newsService.editNews(id,newsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/user/deleteNews/{id}")
    public HttpEntity<?> deleteNews(@PathVariable Long id){
        ApiResponse apiResponse=newsService.deleteNews(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/public/newsById/{id}")
    public HttpEntity<?> newsById(@PathVariable Long id){
        NewsGetDto news=newsService.newsById(id);
        return ResponseEntity.ok(news);
    }

    @GetMapping("/public/allnews")
    public HttpEntity<?> Allnews(int page, int size){
        Page<NewsGetDto> getallService=newsService.getAllServices(page,size);
        return ResponseEntity.ok(getallService);
    }
    @GetMapping("/public/allnewsByList")
    public HttpEntity<?> allnewsByList(){
        List<NewsGetDto> getallService=newsService.allnewsByList();
        return ResponseEntity.ok(getallService);
    }
}
