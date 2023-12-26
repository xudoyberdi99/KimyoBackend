package com.company.service;

import com.company.entity.Vacancies;
import com.company.payload.ApiResponse;
import com.company.payload.VacanciesDto;

import java.util.List;

public interface VacanciesService {
    ApiResponse addVacancie(VacanciesDto vacanciesDto);

    ApiResponse editVacancie(Long id, VacanciesDto vacanciesDto);

    ApiResponse deleteVacancie(Long id);

    Vacancies vacanciegetByid(Long id);

    List<Vacancies> allVacancie();
}
