package com.company.service;

import com.company.entity.Appeals;
import com.company.payload.ApiResponse;
import com.company.payload.AppealsDto;
import org.springframework.data.domain.Page;

public interface AppealsService {
    ApiResponse appealAdd(AppealsDto appealsDto);

    ApiResponse deleteAppeals(Long id);

    Appeals appealsById(Long id);

    Page<Appeals> Allappeals(int page, int size);
}
