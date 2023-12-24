package com.company.service;

import com.company.dto.RegulatoryDocumentsDtoGet;
import com.company.payload.ApiResponse;
import com.company.payload.RegulatoryDocumentsDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RegulationsDocumentsService {
    ApiResponse addRegulationdocument(RegulatoryDocumentsDto regulationsDto);

    ApiResponse editRegulationdocument(Long id, RegulatoryDocumentsDto regulationsDto);

    ApiResponse deleteRegulationdocument(Long id);

    RegulatoryDocumentsDtoGet regulationdocumentByid(Long id);

    Page<RegulatoryDocumentsDtoGet> allregulationdocumentPage(int page, int size);

    List<RegulatoryDocumentsDtoGet> regulationdocument();
}
