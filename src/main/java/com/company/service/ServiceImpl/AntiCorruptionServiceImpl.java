package com.company.service.ServiceImpl;

import com.company.dto.AntiCorruptionDtoGet;
import com.company.entity.AntiCorruption;
import com.company.entity.AttachmentEntity;
import com.company.payload.AntiCorruptionDto;
import com.company.payload.ApiResponse;
import com.company.repository.AntiCorruptionRepository;
import com.company.repository.AttachmentRepository;
import com.company.service.AntiCorruptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AntiCorruptionServiceImpl implements AntiCorruptionService {

    @Autowired
    private AntiCorruptionRepository antiCorruptionRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse addAnticorDocument(AntiCorruptionDto antiCorruptionDto) {
        AntiCorruption antiCorruption=new AntiCorruption();
        antiCorruption.setNameEN(antiCorruption.getNameEN());
        antiCorruption.setNameKR(antiCorruptionDto.getNameKR());
        antiCorruption.setNameUZ(antiCorruptionDto.getNameUZ());
        antiCorruption.setNameRU(antiCorruptionDto.getNameRU());
        antiCorruption.setDescriptionEN(antiCorruptionDto.getDescriptionEN());
        antiCorruption.setDescriptionRU(antiCorruptionDto.getDescriptionRU());
        antiCorruption.setDescriptionKR(antiCorruptionDto.getDescriptionKR());
        antiCorruption.setDescriptionUZ(antiCorruptionDto.getDescriptionUZ());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(antiCorruptionDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found file",false);
        }
        antiCorruption.setAttachment(optional.get());
        antiCorruptionRepository.save(antiCorruption);
        return new ApiResponse("add anticorDocument success", true);
    }

    @Override
    public ApiResponse editAnticorDocument(Long id, AntiCorruptionDto antiCorruptionDto) {
        Optional<AntiCorruption> optionalAntiCorruption = antiCorruptionRepository.findById(id);
        if (!optionalAntiCorruption.isPresent()){
            return new ApiResponse("not found data",false);
        }
        AntiCorruption antiCorruption = optionalAntiCorruption.get();
        antiCorruption.setNameEN(antiCorruption.getNameEN());
        antiCorruption.setNameKR(antiCorruptionDto.getNameKR());
        antiCorruption.setNameUZ(antiCorruptionDto.getNameUZ());
        antiCorruption.setNameRU(antiCorruptionDto.getNameRU());
        antiCorruption.setDescriptionEN(antiCorruptionDto.getDescriptionEN());
        antiCorruption.setDescriptionRU(antiCorruptionDto.getDescriptionRU());
        antiCorruption.setDescriptionKR(antiCorruptionDto.getDescriptionKR());
        antiCorruption.setDescriptionUZ(antiCorruptionDto.getDescriptionUZ());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(antiCorruptionDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found file",false);
        }
        antiCorruption.setAttachment(optional.get());
        antiCorruptionRepository.save(antiCorruption);
        return new ApiResponse("edit anticor success", true);
    }

    @Override
    public ApiResponse deleteAnticorDocument(Long id) {
        return null;
    }

    @Override
    public AntiCorruptionDtoGet AnticorDocumentgetByid(Long id) {
        return null;
    }

    @Override
    public List<AntiCorruptionDtoGet> allAnticorDocument() {
        return null;
    }
}
