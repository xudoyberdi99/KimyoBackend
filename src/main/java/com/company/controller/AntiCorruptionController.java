package com.company.controller;

import com.company.dto.AntiCorruptionDtoGet;
import com.company.dto.OpenDataGetDto;
import com.company.payload.AntiCorruptionDto;
import com.company.payload.ApiResponse;
import com.company.payload.OpenDataDto;
import com.company.service.AntiCorruptionService;
import com.company.service.OpenDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AntiCorruptionController {
    @Autowired
    private AntiCorruptionService antiCorruptionService;

    @PostMapping("/user/addAnticorDocument")
    public ResponseEntity<?> addAnticorDocument(@Valid @RequestBody AntiCorruptionDto antiCorruptionDto){
        ApiResponse apiResponse=antiCorruptionService.addAnticorDocument(antiCorruptionDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editAnticorDocument/{id}")
    public HttpEntity<?> editAnticorDocument(@Valid @PathVariable Long id, @RequestBody AntiCorruptionDto antiCorruptionDto){
        ApiResponse apiResponse=antiCorruptionService.editAnticorDocument(id,antiCorruptionDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteAnticorDocument/{id}")
    public HttpEntity<?> deleteAnticorDocument(@PathVariable Long id){
        ApiResponse apiResponse=antiCorruptionService.deleteAnticorDocument(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/AnticorDocumentgetByid/{id}")
    public HttpEntity<?> AnticorDocumentgetByid(@PathVariable Long id){
        AntiCorruptionDtoGet antiCorruptionDtoGet=antiCorruptionService.AnticorDocumentgetByid(id);
        return ResponseEntity.ok(antiCorruptionDtoGet);
    }


    @GetMapping("/public/allAnticorDocument")
    public HttpEntity<?> allAnticorDocument(){
        List<AntiCorruptionDtoGet> getAll=antiCorruptionService.allAnticorDocument();
        return ResponseEntity.ok(getAll);
    }
}
