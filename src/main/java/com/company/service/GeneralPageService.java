package com.company.service;

import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralPageDto;

public interface GeneralPageService {
    ApiResponse addgeneralpage(GeneralPageDto generalPageDto);

    ApiResponse editGeneralPage(Long id, GeneralPageDto generalPageDto);

    ApiResponse generalpageDelete(Long id);

    Conferences generalPageGetById(Long id);
}
