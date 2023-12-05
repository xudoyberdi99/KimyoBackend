package com.company.service;

import com.company.entity.Conferences;
import com.company.entity.GeneralPage;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralPageDto;

import java.util.List;

public interface GeneralPageService {
    ApiResponse addgeneralpage(GeneralPageDto generalPageDto);

    ApiResponse editGeneralPage(Long id, GeneralPageDto generalPageDto);

    ApiResponse generalpageDelete(Long id);

    GeneralPage generalPageGetById(Long id);

    List<GeneralPage> generalPageGetBycategory(Long categoryid);
}
