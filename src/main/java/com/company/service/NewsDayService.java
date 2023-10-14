package com.company.service;

import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;

public interface NewsDayService {
    ApiResponse saveNews(NewsDayDto newsDayDto);

    ApiResponse editNews(Long id, NewsDayDto newsDayDto);

    ApiResponse deleteNews(Long id);

    NewsDay newsById(Long id);
}
