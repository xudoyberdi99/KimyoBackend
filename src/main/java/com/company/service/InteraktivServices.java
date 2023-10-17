package com.company.service;

import com.company.entity.InteraktivService;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.InteraktivServiceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InteraktivServices {
    ApiResponse addinteractiveService(InteraktivServiceDto interaktivServiceDto);

    ApiResponse editinteractiveService(Long id, InteraktivServiceDto interaktivServiceDto);

    ApiResponse deleteinteractiveService(Long id);

    InteraktivService getinteractiveService(Long id);

    Page<InteraktivService> getAllServices(int page, int size);
}
