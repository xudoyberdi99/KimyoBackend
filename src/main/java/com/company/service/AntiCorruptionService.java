package com.company.service;

import com.company.dto.AntiCorruptionDtoGet;
import com.company.payload.AntiCorruptionDto;
import com.company.payload.ApiResponse;

import java.util.List;

public interface AntiCorruptionService {
    ApiResponse addAnticorDocument(AntiCorruptionDto antiCorruptionDto);

    ApiResponse editAnticorDocument(Long id, AntiCorruptionDto antiCorruptionDto);

    ApiResponse deleteAnticorDocument(Long id);

    AntiCorruptionDtoGet AnticorDocumentgetByid(Long id);

    List<AntiCorruptionDtoGet> allAnticorDocument();
}
