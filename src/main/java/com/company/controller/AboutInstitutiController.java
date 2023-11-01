package com.company.controller;

import com.company.entity.AboutInstituti;
import com.company.payload.AboutInstitutiDto;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.service.AboutInstitutiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AboutInstitutiController {

    @Autowired
    private AboutInstitutiService aboutInstitutiService;

    @PostMapping("/aboutInstituti")
    public ResponseEntity<?> AboutInstitutiSave(@Valid @RequestBody AboutInstitutiDto aboutInstitutiDto){
        ApiResponse apiResponse=aboutInstitutiService.AboutInstitutiSave(aboutInstitutiDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/editAboutInstituti/{id}")
    public HttpEntity<?> editAboutInstituti(@Valid @PathVariable Long id, @RequestBody AboutInstitutiDto aboutInstitutiDto){
        ApiResponse apiResponse=aboutInstitutiService.editAboutInstituti(id,aboutInstitutiDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/deleteAboutInstituti/{id}")
    public HttpEntity<?> deleteAbout(@PathVariable Long id){
        ApiResponse apiResponse=aboutInstitutiService.deleteAbout(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/getAboutInstituti/{id}")
    public HttpEntity<?> AboutGetById(@PathVariable Long id){
        AboutInstituti aboutInstituti=aboutInstitutiService.AboutGetById(id);
        return ResponseEntity.ok(aboutInstituti);
    }
}
