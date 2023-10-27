package com.company.service;

import com.company.entity.News;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.payload.NewsDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NewsService {
    ApiResponse saveNews(NewsDto newsDto);

    ApiResponse editNews(Long id, NewsDto newsDto);

    ApiResponse deleteNews(Long id);

    News newsById(Long id);

    Page<News> getAllServices(int page, int size);
}
