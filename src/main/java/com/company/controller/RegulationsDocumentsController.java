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
    private RegulationsDocumentsService regulationsServices;

    @PostMapping("/user/addRegulationdocument")
    public ResponseEntity<?> addRegulationdocument(@Valid @RequestBody RegulatoryDocumentsDto regulationsDto){
        ApiResponse apiResponse=regulationsServices.addRegulationdocument(regulationsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editRegulationdocument/{id}")
    public HttpEntity<?> editRegulationdocument(@Valid @PathVariable Long id, @RequestBody RegulatoryDocumentsDto regulationsDto){
        ApiResponse apiResponse=regulationsServices.editRegulationdocument(id,regulationsDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteRegulationdocument/{id}")
    public HttpEntity<?> deleteRegulationdocument(@PathVariable Long id){
        ApiResponse apiResponse=regulationsServices.deleteRegulationdocument(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/RegulationdocumentgetByid/{id}")
    public HttpEntity<?> regulationdocumentgetByid(@PathVariable Long id){
        RegulatoryDocumentsDtoGet regulations=regulationsServices.regulationdocumentByid(id);
        return ResponseEntity.ok(regulations);
    }


    @GetMapping("/public/allRegulationgetPagedocument")
    public HttpEntity<?> allregulationdocumentPage(int page, int size){
        Page<RegulatoryDocumentsDtoGet> getAll=regulationsServices.allregulationdocumentPage(page,size);
        return ResponseEntity.ok(getAll);
    }
    @GetMapping("/public/allRegulationdocument")
    public HttpEntity<?> allregulationdocument(){
        List<RegulatoryDocumentsDtoGet> getAll=regulationsServices.regulationdocument();
        return ResponseEntity.ok(getAll);
    }
}
