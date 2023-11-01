package com.company.service;

import com.company.entity.Partners;
import com.company.payload.ApiResponse;
import com.company.payload.PartnersDto;
import org.springframework.data.domain.Page;

public interface PartnersService {
    ApiResponse savepartner(PartnersDto partnersDto);

    ApiResponse editpartner(Long id, PartnersDto partnersDto);

    ApiResponse deletepartner(Long id);

    Partners partnerById(Long id);

    Page<Partners> getAllpartner(int page, int size);
}
