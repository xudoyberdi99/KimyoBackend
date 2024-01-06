package com.company.service;

import com.company.dto.LeadershipGet;
import com.company.entity.Leadership;
import com.company.payload.ApiResponse;
import com.company.payload.LeadershipDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LeadershipService {
    ApiResponse addLeadership(LeadershipDto leadershipDto);

    ApiResponse editLeadership(Long id, LeadershipDto leadershipDto);

    ApiResponse deleteLeadership(Long id);

    LeadershipGet leaderShipById(Long id);

    Page<Leadership> allLeadership(int page, int size);

    List<LeadershipGet> allLeader();

    List<LeadershipGet> allLeaderShipstatusDekanat();

    List<LeadershipGet> allLeaderShipstatusFacultet();
}
