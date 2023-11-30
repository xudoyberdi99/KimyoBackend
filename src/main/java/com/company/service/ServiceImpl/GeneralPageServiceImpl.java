package com.company.service.ServiceImpl;

import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralPageDto;
import com.company.service.GeneralPageService;
import org.springframework.stereotype.Service;

@Service
public class GeneralPageServiceImpl implements GeneralPageService {


    @Override
    public ApiResponse addgeneralpage(GeneralPageDto generalPageDto) {
        return null;
    }

    @Override
    public ApiResponse editGeneralPage(Long id, GeneralPageDto generalPageDto) {
        return null;
    }

    @Override
    public ApiResponse generalpageDelete(Long id) {
        return null;
    }

    @Override
    public Conferences generalPageGetById(Long id) {
        return null;
    }
}
