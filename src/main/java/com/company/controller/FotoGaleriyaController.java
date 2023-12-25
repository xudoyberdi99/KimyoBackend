package com.company.controller;

import com.company.dto.FotoGaleryaDtoGet;
import com.company.entity.Facultys;
import com.company.entity.FotoGaleriya;
import com.company.payload.ApiResponse;
import com.company.payload.FacultyDto;
import com.company.payload.FotoGaleriyaDto;
import com.company.service.FotoGaleriyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FotoGaleriyaController {
    @Autowired
    private FotoGaleriyaService fotoGaleriyaService;

    @PostMapping("/user/addFile")
    public ResponseEntity<?> addFile(@Valid @RequestBody FotoGaleriyaDto fotoGaleriyaDto){
        ApiResponse apiResponse=fotoGaleriyaService.addFile(fotoGaleriyaDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editFile/{id}")
    public HttpEntity<?> editFile(@Valid @PathVariable Long id, @RequestBody FotoGaleriyaDto fotoGaleriyaDto){
        ApiResponse apiResponse=fotoGaleriyaService.editFile(id,fotoGaleriyaDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteFoto/{id}")
    public HttpEntity<?> deleteFoto(@PathVariable Long id){
        ApiResponse apiResponse=fotoGaleriyaService.deleteFoto(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/fotogetByid/{id}")
    public HttpEntity<?> fotogetByid(@PathVariable Long id){
        FotoGaleryaDtoGet fotoGaleriya=fotoGaleriyaService.fotogetByid(id);
        return ResponseEntity.ok(fotoGaleriya);
    }


    @GetMapping("/public/allFoto")
    public HttpEntity<?> allFotos(){
        List<FotoGaleryaDtoGet> getAll=fotoGaleriyaService.allFotos();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/public/allFotoByPage")
    public HttpEntity<?> allFoto(int page, int size){
        Page<FotoGaleriya> getAll=fotoGaleriyaService.allFoto(page,size);
        return ResponseEntity.ok(getAll);
    }
}
