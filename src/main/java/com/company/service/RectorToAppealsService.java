package com.company.service;

import com.company.entity.RectorToAppeals;
import com.company.payload.ApiResponse;
import com.company.payload.RectorToAppealsDto;
import org.springframework.data.domain.Page;

public interface RectorToAppealsService {
    ApiResponse appealAdd(RectorToAppealsDto rectorToAppealsDto);

    ApiResponse deleteAppeals(Long id);

    RectorToAppeals appealsById(Long id);

    Page<RectorToAppeals> Allappeals(int page, int size);
}
