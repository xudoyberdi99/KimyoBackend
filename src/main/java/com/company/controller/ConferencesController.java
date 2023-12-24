package com.company.controller;

import com.company.entity.Announcements;
import com.company.entity.Conferences;
import com.company.payload.AnnouncementsDto;
import com.company.payload.ApiResponse;
import com.company.payload.ConferencesDto;
import com.company.service.ConferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ConferencesController {
    @Autowired
    private ConferencesService conferencesService;

    @PostMapping("/user/conferenceSave")
    public ResponseEntity<?> conferenceSave(@Valid @RequestBody ConferencesDto conferencesDto){
        ApiResponse apiResponse=conferencesService.conferenceSave(conferencesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/user/conferenceEdit/{id}")
    public HttpEntity<?> conferenceEdit(@Valid @PathVariable Long id, @RequestBody ConferencesDto conferencesDto){
        ApiResponse apiResponse=conferencesService.conferenceEdit(id,conferencesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/user/conferenceDelete/{id}")
    public HttpEntity<?> conferenceDelete(@PathVariable Long id){
        ApiResponse apiResponse=conferencesService.conferenceDelete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/public/conferenceGetById/{id}")
    public HttpEntity<?> conferenceGetById(@PathVariable Long id){
        Conferences conferences=conferencesService.conferenceGetById(id);
        return ResponseEntity.ok(conferences);
    }

    @GetMapping("/public/allconference")
    public HttpEntity<?> allconference(int page, int size){
        Page<Conferences> getAllConferens=conferencesService.allconference(page,size);
        return ResponseEntity.ok(getAllConferens);
    }

//    @GetMapping("/public/conferenceGetByCategoryId/{categoryId}")
//    public HttpEntity<?> conferenceGetByCategoryId(@PathVariable Long categoryId,int page, int size){
//        Page<Conferences> getAllConferens=conferencesService.conferenceGetByCategoryId(categoryId,page,size);
//        return ResponseEntity.ok(getAllConferens);
//    }
}
