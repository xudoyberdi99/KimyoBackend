package com.company.controller;

import com.company.entity.Facultys;
import com.company.payload.ApiResponse;
import com.company.payload.FacultyDto;
import com.company.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping("/addFaculty")
    public ResponseEntity<?> addFaculty(@Valid @RequestBody FacultyDto facultyDto){
        ApiResponse apiResponse=facultyService.addFaculty(facultyDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/editFaculty/{id}")
    public HttpEntity<?> editFaculty(@Valid @PathVariable Long id, @RequestBody FacultyDto facultyDto){
        ApiResponse apiResponse=facultyService.editFaculty(id,facultyDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/deleteFaculty/{id}")
    public HttpEntity<?> deleteFaculty(@PathVariable Long id){
        ApiResponse apiResponse=facultyService.deleteFaculty(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/facultyById/{id}")
    public HttpEntity<?> facultyById(@PathVariable Long id){
        Facultys faculty=facultyService.facultyById(id);
        return ResponseEntity.ok(faculty);
    }


    @GetMapping("/allFaculty")
    public HttpEntity<?> allFaculty(){
        List<Facultys> getAllFaculty=facultyService.allFaculty();
        return ResponseEntity.ok(getAllFaculty);
    }
    @GetMapping("/facultyByCategoryId/{categoryId}")
    public HttpEntity<?> facultyByCategoryId(@PathVariable Long categoryId){
        List<Facultys> faculty=facultyService.facultyByCategoryId(categoryId);
        return ResponseEntity.ok(faculty);
    }
}
