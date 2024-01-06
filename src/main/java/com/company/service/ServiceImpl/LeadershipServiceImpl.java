package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.LeadershipGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.Category;
import com.company.entity.Leadership;
import com.company.entity.enums.LeadershipStatus;
import com.company.payload.ApiResponse;
import com.company.payload.LeadershipDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.CategoryRepository;
import com.company.repository.LeadershipRepository;
import com.company.service.LeadershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LeadershipServiceImpl implements LeadershipService {


    @Autowired
    private LeadershipRepository leadershipRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Value("${upload.server}")
    private String serverPath;

    @Override
    public ApiResponse addLeadership(LeadershipDto leadershipDto) {
        Boolean emailcheck = leadershipRepository.existsByEmail(leadershipDto.getEmail());
        if (emailcheck){
            return new ApiResponse("already exists person",false);
        }
        Leadership leadership=new Leadership();

        leadership.setDegree(leadershipDto.getDegree());
        leadership.setBiographyKR(leadershipDto.getBiographyKR());
        leadership.setBiographyEN(leadershipDto.getBiographyEN());
        leadership.setBiographyRU(leadershipDto.getBiographyRU());
        leadership.setBiographyUZ(leadershipDto.getBiographyUZ());
        leadership.setDutiesEN(leadershipDto.getDutiesEN());
        leadership.setDutiesKR(leadershipDto.getDutiesKR());
        leadership.setDutiesUZ(leadershipDto.getDutiesUZ());
        leadership.setDutiesRU(leadershipDto.getDutiesRU());
        leadership.setEmail(leadershipDto.getEmail());
        leadership.setFax(leadershipDto.getFax());
        leadership.setLeadershipStatus(LeadershipStatus.valueOf(leadershipDto.getLeadershipStatus()));
        leadership.setFacebooklink(leadershipDto.getFacebooklink());
        leadership.setInstagramlink(leadershipDto.getInstagramlink());
        leadership.setTelegramlink(leadershipDto.getTelegramlink());
        leadership.setTwitterlink(leadershipDto.getTwitterlink());
        leadership.setFullName(leadershipDto.getFullName());
        leadership.setPhoneNumber(leadershipDto.getPhoneNumber());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(leadershipDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }
        leadership.setImage(optional.get());

        leadershipRepository.save(leadership);
        return new ApiResponse("add leadership success", true);
    }

    @Override
    public ApiResponse editLeadership(Long id, LeadershipDto leadershipDto) {
        Boolean emailAndIdNot = leadershipRepository.existsByEmailAndIdNot(leadershipDto.getEmail(), id);
        if (emailAndIdNot){
            return new ApiResponse("Already exists person", false);
        }
        Optional<Leadership> optionalLeadership = leadershipRepository.findById(id);
        if (!optionalLeadership.isPresent()){
            return new ApiResponse("not found leadership",false);
        }
        Leadership leadership = optionalLeadership.get();
        leadership.setDegree(leadershipDto.getDegree());
        leadership.setBiographyKR(leadershipDto.getBiographyKR());
        leadership.setBiographyEN(leadershipDto.getBiographyEN());
        leadership.setBiographyRU(leadershipDto.getBiographyRU());
        leadership.setBiographyUZ(leadershipDto.getBiographyUZ());
        leadership.setDutiesEN(leadershipDto.getDutiesEN());
        leadership.setDutiesKR(leadershipDto.getDutiesKR());
        leadership.setDutiesUZ(leadershipDto.getDutiesUZ());
        leadership.setDutiesRU(leadershipDto.getDutiesRU());
        leadership.setEmail(leadershipDto.getEmail());
        leadership.setFax(leadershipDto.getFax());
        leadership.setLeadershipStatus(LeadershipStatus.valueOf(leadershipDto.getLeadershipStatus()));
        leadership.setFacebooklink(leadershipDto.getFacebooklink());
        leadership.setInstagramlink(leadershipDto.getInstagramlink());
        leadership.setTelegramlink(leadershipDto.getTelegramlink());
        leadership.setTwitterlink(leadershipDto.getTwitterlink());
        leadership.setFullName(leadershipDto.getFullName());
        leadership.setPhoneNumber(leadershipDto.getPhoneNumber());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(leadershipDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }
        leadership.setImage(optional.get());
        leadershipRepository.save(leadership);
        return new ApiResponse("edit leadership success", true);
    }

    @Override
    public ApiResponse deleteLeadership(Long id) {
        try{
            leadershipRepository.deleteById(id);
            return new ApiResponse("delete Leadership",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public LeadershipGet leaderShipById(Long id) {
        Optional<Leadership> optionalLeadership = leadershipRepository.findById(id);
        if (!optionalLeadership.isPresent()){
            return  new LeadershipGet();
        }
        Leadership leadershipDto = optionalLeadership.get();
        LeadershipGet leadership=new LeadershipGet();

        leadership.setId(leadershipDto.getId());
        leadership.setDegree(leadershipDto.getDegree());
        leadership.setBiographyKR(leadershipDto.getBiographyKR());
        leadership.setBiographyEN(leadershipDto.getBiographyEN());
        leadership.setBiographyRU(leadershipDto.getBiographyRU());
        leadership.setBiographyUZ(leadershipDto.getBiographyUZ());
        leadership.setDutiesEN(leadershipDto.getDutiesEN());
        leadership.setDutiesKR(leadershipDto.getDutiesKR());
        leadership.setDutiesUZ(leadershipDto.getDutiesUZ());
        leadership.setDutiesRU(leadershipDto.getDutiesRU());
        leadership.setEmail(leadershipDto.getEmail());
        leadership.setFax(leadershipDto.getFax());
        leadership.setLeadershipStatus(String.valueOf(leadershipDto.getLeadershipStatus()));
        leadership.setFacebooklink(leadershipDto.getFacebooklink());
        leadership.setInstagramlink(leadershipDto.getInstagramlink());
        leadership.setTelegramlink(leadershipDto.getTelegramlink());
        leadership.setTwitterlink(leadershipDto.getTwitterlink());
        leadership.setFullName(leadershipDto.getFullName());
        leadership.setPhoneNumber(leadershipDto.getPhoneNumber());

        AttachmentEntity image = leadershipDto.getImage();
        AttachDto attachDto=new AttachDto();
        attachDto.setId(image.getId());
        attachDto.setHashId(image.getHashId());
        attachDto.setOrginalName(image.getOrginalName());
        attachDto.setLink(serverPath+image.getUploadFolder());

        leadership.setFile(attachDto);

        return leadership;
    }

    @Override
    public Page<Leadership> allLeadership(int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        return leadershipRepository.findAll(pageable);
    }

    @Override
    public List<LeadershipGet> allLeader() {
        List<Leadership> leaderships = leadershipRepository.allLeadershipRahbariyat();

        List<LeadershipGet> leadershipGetList=new ArrayList<>();

        for (Leadership leadershipDto : leaderships) {
            LeadershipGet leadership=new LeadershipGet();

            leadership.setId(leadershipDto.getId());
            leadership.setDegree(leadershipDto.getDegree());
            leadership.setBiographyKR(leadershipDto.getBiographyKR());
            leadership.setBiographyEN(leadershipDto.getBiographyEN());
            leadership.setBiographyRU(leadershipDto.getBiographyRU());
            leadership.setBiographyUZ(leadershipDto.getBiographyUZ());
            leadership.setDutiesEN(leadershipDto.getDutiesEN());
            leadership.setDutiesKR(leadershipDto.getDutiesKR());
            leadership.setDutiesUZ(leadershipDto.getDutiesUZ());
            leadership.setDutiesRU(leadershipDto.getDutiesRU());
            leadership.setEmail(leadershipDto.getEmail());
            leadership.setFax(leadershipDto.getFax());
            leadership.setLeadershipStatus(String.valueOf(leadershipDto.getLeadershipStatus()));
            leadership.setFacebooklink(leadershipDto.getFacebooklink());
            leadership.setInstagramlink(leadershipDto.getInstagramlink());
            leadership.setTelegramlink(leadershipDto.getTelegramlink());
            leadership.setTwitterlink(leadershipDto.getTwitterlink());
            leadership.setFullName(leadershipDto.getFullName());
            leadership.setPhoneNumber(leadershipDto.getPhoneNumber());

            AttachmentEntity image = leadershipDto.getImage();
            AttachDto attachDto=new AttachDto();
            attachDto.setId(image.getId());
            attachDto.setHashId(image.getHashId());
            attachDto.setOrginalName(image.getOrginalName());
            attachDto.setLink(serverPath+image.getUploadFolder());

            leadership.setFile(attachDto);

            leadershipGetList.add(leadership);
        }
        return leadershipGetList;
    }


    @Override
    public List<LeadershipGet> allLeaderShipstatusDekanat() {
        List<Leadership> allByLeadershipStatusDekanat = leadershipRepository.findAllByLeadershipStatus_Dekanat();

        List<LeadershipGet> leadershipGetList=new ArrayList<>();

        for (Leadership leadershipDto : allByLeadershipStatusDekanat) {
            LeadershipGet leadership=new LeadershipGet();

            leadership.setId(leadershipDto.getId());
            leadership.setDegree(leadershipDto.getDegree());
            leadership.setBiographyKR(leadershipDto.getBiographyKR());
            leadership.setBiographyEN(leadershipDto.getBiographyEN());
            leadership.setBiographyRU(leadershipDto.getBiographyRU());
            leadership.setBiographyUZ(leadershipDto.getBiographyUZ());
            leadership.setDutiesEN(leadershipDto.getDutiesEN());
            leadership.setDutiesKR(leadershipDto.getDutiesKR());
            leadership.setDutiesUZ(leadershipDto.getDutiesUZ());
            leadership.setDutiesRU(leadershipDto.getDutiesRU());
            leadership.setEmail(leadershipDto.getEmail());
            leadership.setFax(leadershipDto.getFax());
            leadership.setLeadershipStatus(String.valueOf(leadershipDto.getLeadershipStatus()));
            leadership.setFacebooklink(leadershipDto.getFacebooklink());
            leadership.setInstagramlink(leadershipDto.getInstagramlink());
            leadership.setTelegramlink(leadershipDto.getTelegramlink());
            leadership.setTwitterlink(leadershipDto.getTwitterlink());
            leadership.setFullName(leadershipDto.getFullName());
            leadership.setPhoneNumber(leadershipDto.getPhoneNumber());

            AttachmentEntity image = leadershipDto.getImage();
            AttachDto attachDto=new AttachDto();
            attachDto.setId(image.getId());
            attachDto.setHashId(image.getHashId());
            attachDto.setOrginalName(image.getOrginalName());
            attachDto.setLink(serverPath+image.getUploadFolder());

            leadership.setFile(attachDto);

            leadershipGetList.add(leadership);
        }
        return leadershipGetList;
    }

    @Override
    public List<LeadershipGet> allLeaderShipstatusFacultet() {
        List<Leadership> allByLeadershipStatusKafedra = leadershipRepository.findAllByLeadershipStatus_Kafedra();

        List<LeadershipGet> leadershipGetList=new ArrayList<>();

        for (Leadership leadershipDto : allByLeadershipStatusKafedra) {
            LeadershipGet leadership=new LeadershipGet();

            leadership.setId(leadershipDto.getId());
            leadership.setDegree(leadershipDto.getDegree());
            leadership.setBiographyKR(leadershipDto.getBiographyKR());
            leadership.setBiographyEN(leadershipDto.getBiographyEN());
            leadership.setBiographyRU(leadershipDto.getBiographyRU());
            leadership.setBiographyUZ(leadershipDto.getBiographyUZ());
            leadership.setDutiesEN(leadershipDto.getDutiesEN());
            leadership.setDutiesKR(leadershipDto.getDutiesKR());
            leadership.setDutiesUZ(leadershipDto.getDutiesUZ());
            leadership.setDutiesRU(leadershipDto.getDutiesRU());
            leadership.setEmail(leadershipDto.getEmail());
            leadership.setFax(leadershipDto.getFax());
            leadership.setLeadershipStatus(String.valueOf(leadershipDto.getLeadershipStatus()));
            leadership.setFacebooklink(leadershipDto.getFacebooklink());
            leadership.setInstagramlink(leadershipDto.getInstagramlink());
            leadership.setTelegramlink(leadershipDto.getTelegramlink());
            leadership.setTwitterlink(leadershipDto.getTwitterlink());
            leadership.setFullName(leadershipDto.getFullName());
            leadership.setPhoneNumber(leadershipDto.getPhoneNumber());

            AttachmentEntity image = leadershipDto.getImage();
            AttachDto attachDto=new AttachDto();
            attachDto.setId(image.getId());
            attachDto.setHashId(image.getHashId());
            attachDto.setOrginalName(image.getOrginalName());
            attachDto.setLink(serverPath+image.getUploadFolder());

            leadership.setFile(attachDto);

            leadershipGetList.add(leadership);
        }
        return leadershipGetList;
    }
}
