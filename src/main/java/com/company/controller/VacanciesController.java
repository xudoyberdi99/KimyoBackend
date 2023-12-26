package com.company.controller;

import com.company.dto.OpenDataGetDto;
import com.company.entity.Vacancies;
import com.company.payload.ApiResponse;
import com.company.payload.OpenDataDto;
import com.company.payload.VacanciesDto;
import com.company.service.OpenDataService;
import com.company.service.VacanciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VacanciesController {
    @Autowired
    private VacanciesService vacanciesService;

    @PostMapping("/user/addVacancie")
    public ResponseEntity<?> addVacancie(@Valid @RequestBody VacanciesDto vacanciesDto){
        ApiResponse apiResponse=vacanciesService.addVacancie(vacanciesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editVacancie/{id}")
    public HttpEntity<?> editVacancie(@Valid @PathVariable Long id, @RequestBody VacanciesDto vacanciesDto){
        ApiResponse apiResponse=vacanciesService.editVacancie(id,vacanciesDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteVacancie/{id}")
    public HttpEntity<?> deleteVacancie(@PathVariable Long id){
        ApiResponse apiResponse=vacanciesService.deleteVacancie(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/VacanciegetByid/{id}")
    public HttpEntity<?> vacanciegetByid(@PathVariable Long id){
        Vacancies vacancies=vacanciesService.vacanciegetByid(id);
        return ResponseEntity.ok(vacancies);
    }


    @GetMapping("/public/allVacancie")
    public HttpEntity<?> allVacancie(){
        List<Vacancies> getAll=vacanciesService.allVacancie();
        return ResponseEntity.ok(getAll);
    }

}
