package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.FacultyGet;
import com.company.dto.LeadershipGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.Category;
import com.company.entity.Facultys;
import com.company.entity.Leadership;
import com.company.payload.ApiResponse;
import com.company.payload.FacultyDto;
import com.company.repository.CategoryRepository;
import com.company.repository.FacultyRepository;
import com.company.repository.LeadershipRepository;
import com.company.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private LeadershipRepository leadershipRepository;
    @Value("${upload.server}")
    private String serverPath;
    @Override
    public ApiResponse addFaculty(FacultyDto facultyDto) {

        Facultys facultys=new Facultys();
        facultys.setNameEN(facultyDto.getNameEN());
        facultys.setNameUZ(facultyDto.getNameUZ());
        facultys.setNameKR(facultyDto.getNameKR());
        facultys.setNameRU(facultyDto.getNameRU());
        facultys.setTitleEN(facultyDto.getTitleEN());
        facultys.setTitleKR(facultyDto.getTitleKR());
        facultys.setTitleUZ(facultyDto.getTitleUZ());
        facultys.setTitleRU(facultyDto.getTitleRU());
        facultys.setDescriptionKR(facultyDto.getDescriptionKR());
        facultys.setDescriptionEN(facultyDto.getDescriptionEN());
        facultys.setDescriptionRU(facultyDto.getDescriptionRU());
        facultys.setDescriptionUZ(facultyDto.getDescriptionUZ());
        Optional<Leadership> optionalLeadership = leadershipRepository.findById(facultyDto.getLeadershipId());
        if (!optionalLeadership.isPresent()){
            return new ApiResponse("not found leadership", false);
        }
        facultys.setLeadership(optionalLeadership.get());

        facultyRepository.save(facultys);
        return new ApiResponse("add faculty success", true);
    }

    @Override
    public ApiResponse editFaculty(Long id, FacultyDto facultyDto) {
        Optional<Facultys> facultyRepositoryById = facultyRepository.findById(id);
        if (!facultyRepositoryById.isPresent()){
            return new ApiResponse("not found faculty", false);
        }
        Facultys facultys = facultyRepositoryById.get();
        facultys.setNameEN(facultyDto.getNameEN());
        facultys.setNameUZ(facultyDto.getNameUZ());
        facultys.setNameKR(facultyDto.getNameKR());
        facultys.setNameRU(facultyDto.getNameRU());
        facultys.setTitleEN(facultyDto.getTitleEN());
        facultys.setTitleKR(facultyDto.getTitleKR());
        facultys.setTitleUZ(facultyDto.getTitleUZ());
        facultys.setTitleRU(facultyDto.getTitleRU());
        facultys.setDescriptionKR(facultyDto.getDescriptionKR());
        facultys.setDescriptionEN(facultyDto.getDescriptionEN());
        facultys.setDescriptionRU(facultyDto.getDescriptionRU());
        facultys.setDescriptionUZ(facultyDto.getDescriptionUZ());
        Optional<Leadership> optionalLeadership = leadershipRepository.findById(facultyDto.getLeadershipId());
        if (!optionalLeadership.isPresent()){
            return new ApiResponse("not found leadership", false);
        }
        facultys.setLeadership(optionalLeadership.get());

        facultyRepository.save(facultys);
        return new ApiResponse("edit faculty success", true);
    }

    @Override
    public ApiResponse deleteFaculty(Long id) {
        try{
            facultyRepository.deleteById(id);
            return new ApiResponse("delete Faculty",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public FacultyGet facultyById(Long id) {
        Optional<Facultys> facultyRepositoryById = facultyRepository.findById(id);
        if (!facultyRepositoryById.isPresent()){
            return new FacultyGet();
        }
        Facultys facultyDto = facultyRepositoryById.get();

        FacultyGet facultys=new FacultyGet();

        facultys.setId(facultyDto.getId());
        facultys.setNameEN(facultyDto.getNameEN());
        facultys.setNameUZ(facultyDto.getNameUZ());
        facultys.setNameKR(facultyDto.getNameKR());
        facultys.setNameRU(facultyDto.getNameRU());
        facultys.setTitleEN(facultyDto.getTitleEN());
        facultys.setTitleKR(facultyDto.getTitleKR());
        facultys.setTitleUZ(facultyDto.getTitleUZ());
        facultys.setTitleRU(facultyDto.getTitleRU());
        facultys.setDescriptionKR(facultyDto.getDescriptionKR());
        facultys.setDescriptionEN(facultyDto.getDescriptionEN());
        facultys.setDescriptionRU(facultyDto.getDescriptionRU());
        facultys.setDescriptionUZ(facultyDto.getDescriptionUZ());


        Leadership leadershipDto = facultyDto.getLeadership();
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

        facultys.setLeadership(leadership);

        return facultys;
    }

    @Override
    public List<FacultyGet> allFaculty() {
        List<Facultys> allFaculty = facultyRepository.findAll();
        List<FacultyGet> allFacultyList=new ArrayList<>();

        for (Facultys facultyDto : allFaculty) {
            FacultyGet facultys=new FacultyGet();

            facultys.setId(facultyDto.getId());
            facultys.setNameEN(facultyDto.getNameEN());
            facultys.setNameUZ(facultyDto.getNameUZ());
            facultys.setNameKR(facultyDto.getNameKR());
            facultys.setNameRU(facultyDto.getNameRU());
            facultys.setTitleEN(facultyDto.getTitleEN());
            facultys.setTitleKR(facultyDto.getTitleKR());
            facultys.setTitleUZ(facultyDto.getTitleUZ());
            facultys.setTitleRU(facultyDto.getTitleRU());
            facultys.setDescriptionKR(facultyDto.getDescriptionKR());
            facultys.setDescriptionEN(facultyDto.getDescriptionEN());
            facultys.setDescriptionRU(facultyDto.getDescriptionRU());
            facultys.setDescriptionUZ(facultyDto.getDescriptionUZ());


            Leadership leadershipDto = facultyDto.getLeadership();
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

            facultys.setLeadership(leadership);

            allFacultyList.add(facultys);
        }
        return allFacultyList;
    }
}
