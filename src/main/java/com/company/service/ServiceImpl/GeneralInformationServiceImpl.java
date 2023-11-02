package com.company.service.ServiceImpl;

import com.company.entity.GeneralInformation;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralInformationDto;
import com.company.payload.NewsDayDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.GeneralInformationRepository;
import com.company.service.GeneralInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralInformationServiceImpl implements GeneralInformationService {

    @Autowired
    private GeneralInformationRepository generalInformationRepository;

    @Override
    public ApiResponse saveGeneralInformat(GeneralInformationDto generalInformationDto) {
        GeneralInformation generalInformation=new GeneralInformation();

        generalInformation.setFacultyNumber(generalInformationDto.getFacultyNumber());
        generalInformation.setDoktorantNumber(generalInformationDto.getDoktorantNumber());
        generalInformation.setAuditoriumNumber(generalInformationDto.getAuditoriumNumber());
        generalInformation.setProffessorNumber(generalInformationDto.getProffessorNumber());
        generalInformation.setStudentsNumber(generalInformationDto.getStudentsNumber());
        generalInformation.setFieldsofStudyNumber(generalInformationDto.getFieldsofStudyNumber());
        generalInformation.setJointTrainingNumber(generalInformationDto.getJointTrainingNumber());
        generalInformation.setIndependentResearchersNumber(generalInformationDto.getIndependentResearchersNumber());

        generalInformationRepository.save(generalInformation);
        return new ApiResponse("add general Information success", true);
    }

    @Override
    public ApiResponse editGeneralInformat(Long id, GeneralInformationDto generalInformationDto) {
        Optional<GeneralInformation> informationRepositoryById = generalInformationRepository.findById(id);

        if (!informationRepositoryById.isPresent()){
            return new ApiResponse("not found general information", false);
        }
        GeneralInformation generalInformation = informationRepositoryById.get();
        generalInformation.setFacultyNumber(generalInformationDto.getFacultyNumber());
        generalInformation.setDoktorantNumber(generalInformationDto.getDoktorantNumber());
        generalInformation.setAuditoriumNumber(generalInformationDto.getAuditoriumNumber());
        generalInformation.setProffessorNumber(generalInformationDto.getProffessorNumber());
        generalInformation.setStudentsNumber(generalInformationDto.getStudentsNumber());
        generalInformation.setFieldsofStudyNumber(generalInformationDto.getFieldsofStudyNumber());
        generalInformation.setJointTrainingNumber(generalInformationDto.getJointTrainingNumber());
        generalInformation.setIndependentResearchersNumber(generalInformationDto.getIndependentResearchersNumber());

        generalInformationRepository.save(generalInformation);
        return new ApiResponse("edit general Information success", true);
    }

    @Override
    public ApiResponse deleteGeneralInformat(Long id) {
        try{
            generalInformationRepository.deleteById(id);
            return new ApiResponse("delete general information",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public GeneralInformation GeneralInformatById(Long id) {
        return generalInformationRepository.findById(id).orElse(new GeneralInformation());
    }
}
