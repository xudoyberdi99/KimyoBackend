package com.company.controller;

import com.company.dto.RegulationDtoGet;
import com.company.entity.FotoGaleriya;
import com.company.entity.Regulations;
import com.company.payload.ApiResponse;
import com.company.payload.FotoGaleriyaDto;
import com.company.payload.RegulationsDto;
import com.company.service.FotoGaleriyaService;
import com.company.service.RegulationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RegulationsController {

    @Autowired
    private RegulationsService regulationsService;

    @PostMapping("/user/addRegulation")
    public ResponseEntity<?> addRegulation(@Valid @RequestBody RegulationsDto regulationsDto){
        ApiResponse apiResponse=regulationsService.addRegulation(regulationsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editRegulation/{id}")
    public HttpEntity<?> editRegulation(@Valid @PathVariable Long id, @RequestBody RegulationsDto regulationsDto){
        ApiResponse apiResponse=regulationsService.editRegulation(id,regulationsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteRegulation/{id}")
    public HttpEntity<?> deleteRegulation(@PathVariable Long id){
        ApiResponse apiResponse=regulationsService.deleteRegulation(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/RegulationgetByid/{id}")
    public HttpEntity<?> RegulationgetByid(@PathVariable Long id){
        RegulationDtoGet regulations=regulationsService.regulationgetByid(id);
        return ResponseEntity.ok(regulations);
    }


    @GetMapping("/public/allRegulationgetPage")
    public HttpEntity<?> allRegulationgetPage(int page, int size){
        Page<RegulationDtoGet> getAll=regulationsService.allRegulationgetPage(page,size);
        return ResponseEntity.ok(getAll);
    }
    @GetMapping("/public/allRegulation")
    public HttpEntity<?> allRegulation(){
        List<RegulationDtoGet> getAll=regulationsService.allRegulation();
        return ResponseEntity.ok(getAll);
    }
}
