package com.company.service;

import com.company.dto.AnnouncementDtoGet;
import com.company.entity.Announcements;
import com.company.entity.News;
import com.company.payload.AnnouncementsDto;
import com.company.payload.ApiResponse;
import org.springframework.data.domain.Page;

public interface AnnouncementsService {
    ApiResponse announcementSave(AnnouncementsDto announcementsDto);

    ApiResponse announcementEdit(Long id, AnnouncementsDto announcementsDto);

    ApiResponse announcementDelete(Long id);

    AnnouncementDtoGet announcementGetById(Long id);

    Page<AnnouncementDtoGet> allAnnouncement(int page, int size);

    Page<AnnouncementDtoGet> allAnnouncementGetCategoryId(Long categoryid, int page, int size);
}
