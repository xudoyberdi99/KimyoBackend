package com.company.service.ServiceImpl;

import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.service.NewsDayService;
import org.springframework.stereotype.Service;

@Service
public class NewsDayServiceImpl implements NewsDayService {


    @Override
    public ApiResponse saveNews(NewsDayDto newsDayDto) {
        return null;
    }

    @Override
    public ApiResponse editNews(Long id, NewsDayDto newsDayDto) {
        return null;
    }

    @Override
    public ApiResponse deleteNews(Long id) {
        return null;
    }

    @Override
    public NewsDay newsById(Long id) {
        return null;
    }
}
