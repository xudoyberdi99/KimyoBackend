package com.company.controller;

import com.company.dto.OpenDataGetDto;
import com.company.dto.RegulationDtoGet;
import com.company.payload.ApiResponse;
import com.company.payload.OpenDataDto;
import com.company.payload.RegulationsDto;
import com.company.service.OpenDataService;
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
public class OpenDataController {

    @Autowired
    private OpenDataService openDataService;

    @PostMapping("/user/addOpendata")
    public ResponseEntity<?> addOpendata(@Valid @RequestBody OpenDataDto openDataDto){
        ApiResponse apiResponse=openDataService.addOpendata(openDataDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editOpendata/{id}")
    public HttpEntity<?> editOpendata(@Valid @PathVariable Long id, @RequestBody OpenDataDto openDataDto){
        ApiResponse apiResponse=openDataService.editOpendata(id,openDataDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteOpendata/{id}")
    public HttpEntity<?> deleteOpendata(@PathVariable Long id){
        ApiResponse apiResponse=openDataService.deleteOpendata(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/OpendatagetByid/{id}")
    public HttpEntity<?> OpendatagetByid(@PathVariable Long id){
        OpenDataGetDto openDataGetDto=openDataService.OpendatagetByid(id);
        return ResponseEntity.ok(openDataGetDto);
    }


    @GetMapping("/public/allOpendata")
    public HttpEntity<?> allOpendata(){
        List<OpenDataGetDto> getAll=openDataService.allOpendata();
        return ResponseEntity.ok(getAll);
    }
}
