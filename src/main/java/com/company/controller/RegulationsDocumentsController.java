package com.company.controller;

import com.company.dto.RegulationDtoGet;
import com.company.dto.RegulatoryDocumentsDtoGet;
import com.company.payload.ApiResponse;
import com.company.payload.RegulationsDto;
import com.company.payload.RegulatoryDocumentsDto;
import com.company.service.RegulationsDocumentsService;
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
public class RegulationsDocumentsController {

    @Autowired
    private RegulationsDocumentsService regulationsService;

    @PostMapping("/user/addRegulationdocument")
    public ResponseEntity<?> addRegulationdocument(@Valid @RequestBody RegulatoryDocumentsDto regulationsDto){
        ApiResponse apiResponse=regulationsService.addRegulationdocument(regulationsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editRegulation/{id}")
    public HttpEntity<?> editRegulationdocument(@Valid @PathVariable Long id, @RequestBody RegulatoryDocumentsDto regulationsDto){
        ApiResponse apiResponse=regulationsService.editRegulationdocument(id,regulationsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteRegulation/{id}")
    public HttpEntity<?> deleteRegulationdocument(@PathVariable Long id){
        ApiResponse apiResponse=regulationsService.deleteRegulationdocument(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/RegulationdocumentgetByid/{id}")
    public HttpEntity<?> regulationdocumentgetByid(@PathVariable Long id){
        RegulatoryDocumentsDtoGet regulations=regulationsService.regulationdocumentByid(id);
        return ResponseEntity.ok(regulations);
    }


    @GetMapping("/public/allRegulationgetPage")
    public HttpEntity<?> allregulationdocumentPage(int page, int size){
        Page<RegulatoryDocumentsDtoGet> getAll=regulationsService.allregulationdocumentPage(page,size);
        return ResponseEntity.ok(getAll);
    }
    @GetMapping("/public/allRegulation")
    public HttpEntity<?> allregulationdocument(){
        List<RegulatoryDocumentsDtoGet> getAll=regulationsService.regulationdocument();
        return ResponseEntity.ok(getAll);
    }
}
