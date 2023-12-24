package com.company.service;

import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.ConferencesDto;
import org.springframework.data.domain.Page;

public interface ConferencesService {
    ApiResponse conferenceSave(ConferencesDto conferencesDto);

    ApiResponse conferenceEdit(Long id, ConferencesDto conferencesDto);

    ApiResponse conferenceDelete(Long id);

    Conferences conferenceGetById(Long id);

    Page<Conferences> allconference(int page, int size);

//    Page<Conferences> conferenceGetByCategoryId(Long categoryId, int page, int size);
}
