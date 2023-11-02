package com.company.service;

import com.company.entity.GeneralInformation;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralInformationDto;
import com.company.payload.NewsDayDto;

public interface GeneralInformationService {
    ApiResponse saveGeneralInformat(GeneralInformationDto generalInformationDto);

    ApiResponse editGeneralInformat(Long id, GeneralInformationDto generalInformationDto);

    ApiResponse deleteGeneralInformat(Long id);

    GeneralInformation GeneralInformatById(Long id);
}
