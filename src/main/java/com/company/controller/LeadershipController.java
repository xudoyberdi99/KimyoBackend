package com.company.controller;

import com.company.dto.LeadershipGet;
import com.company.entity.Leadership;
import com.company.entity.News;
import com.company.payload.ApiResponse;
import com.company.payload.LeadershipDto;
import com.company.payload.NewsDto;
import com.company.service.LeadershipService;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LeadershipController {
    @Autowired
    private LeadershipService leadershipService;

    @PostMapping("/user/addLeadership")
    public ResponseEntity<?> addLeadership(@Valid @RequestBody LeadershipDto leadershipDto){
        ApiResponse apiResponse=leadershipService.addLeadership(leadershipDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/user/editLeadership/{id}")
    public HttpEntity<?> editLeadership(@Valid @PathVariable Long id, @RequestBody LeadershipDto leadershipDto){
        ApiResponse apiResponse=leadershipService.editLeadership(id,leadershipDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @DeleteMapping("/user/deleteLeadership/{id}")
    public HttpEntity<?> deleteLeadership(@PathVariable Long id){
        ApiResponse apiResponse=leadershipService.deleteLeadership(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @GetMapping("/public/leaderShipById/{id}")
    public HttpEntity<?> leaderShipById(@PathVariable Long id){
        LeadershipGet leadership=leadershipService.leaderShipById(id);
        return ResponseEntity.ok(leadership);
    }


    @GetMapping("/public/allLeadership")
    public HttpEntity<?> allLeadership(int page, int size){
        Page<Leadership> getallleadership=leadershipService.allLeadership(page,size);
        return ResponseEntity.ok(getallleadership);
    }

    @GetMapping("/public/allLeader")
    public HttpEntity<?> allLeader(){
        List<LeadershipGet> getallleader=leadershipService.allLeader();
        return ResponseEntity.ok(getallleader);
    }
    @GetMapping("/public/allLeaderShipstatusDekanat")
    public HttpEntity<?> allLeaderShipstatusDekanat(){
        List<LeadershipGet> getallleader=leadershipService.allLeaderShipstatusDekanat();
        return ResponseEntity.ok(getallleader);
    }
    @GetMapping("/public/allLeaderShipstatusFacultet")
    public HttpEntity<?> allLeaderShipstatusFacultet(){
        List<LeadershipGet> getallleader=leadershipService.allLeaderShipstatusFacultet();
        return ResponseEntity.ok(getallleader);
    }

}
