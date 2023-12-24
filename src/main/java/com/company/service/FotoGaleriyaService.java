package com.company.service;

import com.company.entity.FotoGaleriya;
import com.company.payload.ApiResponse;
import com.company.payload.FotoGaleriyaDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface FotoGaleriyaService {
    ApiResponse addFile(FotoGaleriyaDto fotoGaleriyaDto);

    ApiResponse editFile(Long id, FotoGaleriyaDto fotoGaleriyaDto);

    ApiResponse deleteFoto(Long id);

    FotoGaleriya fotogetByid(Long id);

    Page<FotoGaleriya> allFoto(int page, int size);
}
