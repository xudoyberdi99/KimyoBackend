package com.company.controller;

import com.company.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService announcementsService;

}
