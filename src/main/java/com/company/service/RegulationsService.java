package com.company.service;

import com.company.dto.RegulationDtoGet;
import com.company.entity.Regulations;
import com.company.payload.ApiResponse;
import com.company.payload.RegulationsDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RegulationsService {
    ApiResponse addRegulation(RegulationsDto regulationsDto);

    ApiResponse editRegulation(Long id, RegulationsDto regulationsDto);

    ApiResponse deleteRegulation(Long id);

    RegulationDtoGet regulationgetByid(Long id);

    Page<RegulationDtoGet> allRegulationgetPage(int page, int size);

    List<RegulationDtoGet> allRegulation();
}
