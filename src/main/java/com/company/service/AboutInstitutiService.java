package com.company.service;

import com.company.entity.AboutInstituti;
import com.company.payload.AboutInstitutiDto;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;

import javax.validation.Valid;

public interface AboutInstitutiService {
    ApiResponse AboutInstitutiSave( AboutInstitutiDto aboutInstitutiDto);

    ApiResponse editAboutInstituti(Long id, AboutInstitutiDto aboutInstitutiDto);

    ApiResponse deleteAbout(Long id);

    AboutInstituti AboutGetById(Long id);

    AboutInstituti getByCategoryIdAboutInstituti(Long categoryid);
}
