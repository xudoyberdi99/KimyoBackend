package com.company.controller;

import com.company.entity.News;
import com.company.entity.Partners;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDto;
import com.company.payload.PartnersDto;
import com.company.service.NewsService;
import com.company.service.PartnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class PartnersController {
    @Autowired
    private PartnersService partnersService;

    @PostMapping("/user/partner")
    public ResponseEntity<?> addpartner(@Valid @RequestBody PartnersDto partnersDto){
        ApiResponse apiResponse=partnersService.savepartner(partnersDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/user/editpartner/{id}")
    public HttpEntity<?> editpartner(@Valid @PathVariable Long id, @RequestBody PartnersDto partnersDto){
        ApiResponse apiResponse=partnersService.editpartner(id,partnersDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/user/deletepartner/{id}")
    public HttpEntity<?> deletepartner(@PathVariable Long id){
        ApiResponse apiResponse=partnersService.deletepartner(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/public/partnerById/{id}")
    public HttpEntity<?> partnersById(@PathVariable Long id){
        Partners partner=partnersService.partnerById(id);
        return ResponseEntity.ok(partner);
    }

    @GetMapping("/public/allpartner")
    public HttpEntity<?> AllPartners(int page, int size){
        Page<Partners> partners=partnersService.getAllpartner(page,size);
        return ResponseEntity.ok(partners);
    }
}
