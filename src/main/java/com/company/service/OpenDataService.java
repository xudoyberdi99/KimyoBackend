package com.company.service;

import com.company.dto.OpenDataGetDto;
import com.company.dto.RegulationDtoGet;
import com.company.payload.ApiResponse;
import com.company.payload.OpenDataDto;

import java.util.List;

public interface OpenDataService {
    ApiResponse addOpendata(OpenDataDto openDataDto);

    ApiResponse editOpendata(Long id, OpenDataDto openDataDto);

    ApiResponse deleteOpendata(Long id);

    OpenDataGetDto OpendatagetByid(Long id);

    List<OpenDataGetDto> allOpendata();
}
