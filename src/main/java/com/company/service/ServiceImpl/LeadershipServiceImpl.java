package com.company.service.ServiceImpl;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadershipServiceImpl implements LeadershipService {


    @Autowired
    private LeadershipRepository leadershipRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private CategoryRepository categoryRepository;

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
        Optional<Category> categoryOptional = categoryRepository.findById(leadershipDto.getCategoryId());
        if (!categoryOptional.isPresent()){
            return new ApiResponse("not found category", false);
        }
        leadership.setCategory(categoryOptional.get());

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
        Optional<Category> categoryOptional = categoryRepository.findById(leadershipDto.getCategoryId());
        if (!categoryOptional.isPresent()){
            return new ApiResponse("not found category", false);
        }
        leadership.setCategory(categoryOptional.get());
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
    public Leadership leaderShipById(Long id) {
        return leadershipRepository.findById(id).orElse(new Leadership());
    }

    @Override
    public Page<Leadership> allLeadership(int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        return leadershipRepository.findAll(pageable);
    }

    @Override
    public List<Leadership> allLeader() {
        return leadershipRepository.allLeadershipRahbariyat();
    }

    @Override
    public Page<Leadership> allLeadershipByCategoryId(Long categoryId, int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        List<Leadership> allByCategoryId = leadershipRepository.findAllByCategory_Id(categoryId);
        Page<Leadership> allLeadbyCategoryId=new PageImpl<>(allByCategoryId,pageable,allByCategoryId.size());
        return allLeadbyCategoryId;
    }
}
