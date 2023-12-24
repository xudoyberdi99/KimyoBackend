package com.company.service;

import com.company.entity.Requisites;
import com.company.payload.ApiResponse;
import com.company.payload.RequisitesDto;

public interface RequisitesService {
    ApiResponse Requisitesave(RequisitesDto requisitesDto);

    ApiResponse editRequisite(Long id, RequisitesDto requisitesDto);

    ApiResponse deleteRequisite(Long id);

    Requisites requisiteById(Long id);
}
