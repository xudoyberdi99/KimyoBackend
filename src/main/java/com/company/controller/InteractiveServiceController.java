package com.company.controller;

import com.company.entity.InteraktivService;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.InteraktivServiceDto;
import com.company.payload.NewsDayDto;
import com.company.service.InteraktivServices;
import com.company.service.NewsDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class InteractiveServiceController {
    @Autowired
    private InteraktivServices interaktivService;

    @PostMapping("/addService")
    public ResponseEntity<?> addinteractiveService(@Valid @RequestBody InteraktivServiceDto interaktivServiceDto){
        ApiResponse apiResponse=interaktivService.addinteractiveService(interaktivServiceDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @PutMapping("/editservice/{id}")
    public HttpEntity<?> editinteractiveService(@Valid @PathVariable Long id, @RequestBody InteraktivServiceDto interaktivServiceDto){
        ApiResponse apiResponse=interaktivService.editinteractiveService(id,interaktivServiceDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/deleteservice/{id}")
    public HttpEntity<?> deleteinteractiveService(@PathVariable Long id){
        ApiResponse apiResponse=interaktivService.deleteinteractiveService(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @GetMapping("/getByIdService/{id}")
    public HttpEntity<?> getinteractiveService(@PathVariable Long id){
        InteraktivService getByidinteraktivService=interaktivService.getinteractiveService(id);
        return ResponseEntity.ok(getByidinteraktivService);
    }
    @GetMapping("/allService")
    public HttpEntity<?> getAllService(int page, int size){
        Page<InteraktivService> getallService=interaktivService.getAllServices(page,size);
        return ResponseEntity.ok(getallService);
    }
}
