package com.company.service.ServiceImpl;

import com.company.entity.Facultys;
import com.company.entity.Leadership;
import com.company.payload.ApiResponse;
import com.company.payload.FacultyDto;
import com.company.repository.FacultyRepository;
import com.company.repository.LeadershipRepository;
import com.company.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private LeadershipRepository leadershipRepository;


    @Override
    public ApiResponse addFaculty(FacultyDto facultyDto) {
        Facultys facultys=new Facultys();
        facultys.setNameEN(facultyDto.getNameEN());
        facultys.setNameUZ(facultyDto.getNameUZ());
        facultys.setNameKR(facultyDto.getNameKR());
        facultys.setNameRU(facultyDto.getNameRU());
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
    public Facultys facultyById(Long id) {
        return facultyRepository.findById(id).orElse(new Facultys());
    }

    @Override
    public List<Facultys> allFaculty() {
        return facultyRepository.findAll();
    }
}
