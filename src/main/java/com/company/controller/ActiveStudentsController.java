package com.company.controller;

import com.company.entity.ActiveStudents;
import com.company.payload.ActiveStudentsDto;
import com.company.payload.ApiResponse;
import com.company.service.ActiveStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ActiveStudentsController {
    @Autowired
    private ActiveStudentsService activeStudentsService;

    @PostMapping("/user/addStudents")
    public ResponseEntity<?> addStudents(@Valid @RequestBody ActiveStudentsDto activeStudentsDto){
        ApiResponse apiResponse=activeStudentsService.addStudents(activeStudentsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/user/editStudents/{id}")
    public HttpEntity<?> editStudents(@Valid @PathVariable Long id, @RequestBody ActiveStudentsDto activeStudentsDto){
        ApiResponse apiResponse=activeStudentsService.editStudents(id,activeStudentsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/user/deleteStudent/{id}")
    public HttpEntity<?> deleteStudent(@PathVariable Long id){
        ApiResponse apiResponse=activeStudentsService.deleteStudent(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/public/getByIdStudents/{id}")
    public HttpEntity<?> getByIdStudents(@PathVariable Long id){
        ActiveStudents activeStudents=activeStudentsService.getByIdStudents(id);
        return ResponseEntity.ok(activeStudents);
    }
    @GetMapping("/public/allStudents")
    public HttpEntity<?> allStudents(int page, int size){
        Page<ActiveStudents> activeStudents=activeStudentsService.allStudents(page,size);
        return ResponseEntity.ok(activeStudents);
    }

    @GetMapping("/public/allgraduated")
    public HttpEntity<?> allgraduated(int page, int size){
        Page<ActiveStudents> activeStudents=activeStudentsService.allgraduated(page,size);
        return ResponseEntity.ok(activeStudents);
    }
    @GetMapping("/public/allStudentCategory/{categoryid}")
    public HttpEntity<?> allcategory(@PathVariable Long categoryid,int page, int size){
        Page<ActiveStudents> activeStudents=activeStudentsService.allcategory(categoryid,page,size);
        return ResponseEntity.ok(activeStudents);
    }
}
