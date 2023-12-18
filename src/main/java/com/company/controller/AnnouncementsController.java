package com.company.controller;

import com.company.dto.AnnouncementDtoGet;
import com.company.entity.Announcements;
import com.company.entity.News;
import com.company.payload.AnnouncementsDto;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDto;
import com.company.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Transactional
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

    @PostMapping("/announcementSave")
    public ResponseEntity<?> announcementSave(@Valid @RequestBody AnnouncementsDto announcementsDto){
        ApiResponse apiResponse=announcementsService.announcementSave(announcementsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/announcementEdit/{id}")
    public HttpEntity<?> announcementEdit(@Valid @PathVariable Long id, @RequestBody AnnouncementsDto announcementsDto){
        ApiResponse apiResponse=announcementsService.announcementEdit(id,announcementsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/announcementDelete/{id}")
    public HttpEntity<?> announcementDelete(@PathVariable Long id){
        ApiResponse apiResponse=announcementsService.announcementDelete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/announcementGetById/{id}")
    public HttpEntity<?> announcementGetById(@PathVariable Long id){
        AnnouncementDtoGet announcements=announcementsService.announcementGetById(id);
        return ResponseEntity.ok(announcements);
    }

    @GetMapping("/allAnnouncement")
    public HttpEntity<?> allAnnouncement(int page, int size){
        Page<AnnouncementDtoGet> getAllAnnouncement=announcementsService.allAnnouncement(page,size);
        return ResponseEntity.ok(getAllAnnouncement);
    }
    @GetMapping("/allAnnouncementGetCategoryId/{categoryid}")
    public HttpEntity<?> allAnnouncementGetCategoryId(@PathVariable Long categoryid,int page, int size){
        Page<AnnouncementDtoGet> getAllAnnouncement=announcementsService.allAnnouncementGetCategoryId(categoryid,page,size);
        return ResponseEntity.ok(getAllAnnouncement);
    }

}
