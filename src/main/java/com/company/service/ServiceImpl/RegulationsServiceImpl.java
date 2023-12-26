package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.NewsGetDto;
import com.company.dto.RegulationDtoGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.Regulations;
import com.company.payload.ApiResponse;
import com.company.payload.RegulationsDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.RegulationsRepository;
import com.company.service.RegulationsService;
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
public class RegulationsServiceImpl implements RegulationsService {

    @Autowired
    private RegulationsRepository regulationsRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Value("${upload.server}")
    private String serverPath;
    @Override
    public ApiResponse addRegulation(RegulationsDto regulationsDto) {
        Regulations regulations=new Regulations();
        regulations.setDescriptionRU(regulationsDto.getDescriptionRU());
        regulations.setDescriptionKR(regulationsDto.getDescriptionKR());
        regulations.setDescriptionEN(regulationsDto.getDescriptionEN());
        regulations.setDescriptionUZ(regulationsDto.getDescriptionUZ());
        regulations.setNameEN(regulationsDto.getNameEN());
        regulations.setNameUZ(regulationsDto.getNameUZ());
        regulations.setNameKR(regulationsDto.getNameKR());
        regulations.setNameRU(regulationsDto.getNameRU());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(regulationsDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found file",false);
        }
        regulations.setAttachment(optional.get());
        regulationsRepository.save(regulations);
        return new ApiResponse("regulation add success",true);
    }

    @Override
    public ApiResponse editRegulation(Long id, RegulationsDto regulationsDto) {
        Optional<Regulations> regulationsRepositoryById = regulationsRepository.findById(id);
        if (!regulationsRepositoryById.isPresent()){
            return new ApiResponse("not found regular", false);
        }
        Regulations regulations = regulationsRepositoryById.get();
        regulations.setDescriptionRU(regulationsDto.getDescriptionRU());
        regulations.setDescriptionKR(regulationsDto.getDescriptionKR());
        regulations.setDescriptionEN(regulationsDto.getDescriptionEN());
        regulations.setDescriptionUZ(regulationsDto.getDescriptionUZ());
        regulations.setNameEN(regulationsDto.getNameEN());
        regulations.setNameUZ(regulationsDto.getNameUZ());
        regulations.setNameKR(regulationsDto.getNameKR());
        regulations.setNameRU(regulationsDto.getNameRU());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(regulationsDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found file",false);
        }
        regulations.setAttachment(optional.get());
        regulationsRepository.save(regulations);
        return new ApiResponse("regulation edit success",true);
    }

    @Override
    public ApiResponse deleteRegulation(Long id) {
        try{
            regulationsRepository.deleteById(id);
            return new ApiResponse("delete regulation",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public RegulationDtoGet regulationgetByid(Long id) {
        Optional<Regulations> regulationsRepositoryById = regulationsRepository.findById(id);
        if (!regulationsRepositoryById.isPresent()){
            return new RegulationDtoGet();
        }
        Regulations regulationsDto = regulationsRepositoryById.get();
        RegulationDtoGet regulations=new RegulationDtoGet();
        regulations.setId(regulationsDto.getId());
        regulations.setDescriptionRU(regulationsDto.getDescriptionRU());
        regulations.setDescriptionKR(regulationsDto.getDescriptionKR());
        regulations.setDescriptionEN(regulationsDto.getDescriptionEN());
        regulations.setDescriptionUZ(regulationsDto.getDescriptionUZ());
        regulations.setNameEN(regulationsDto.getNameEN());
        regulations.setNameUZ(regulationsDto.getNameUZ());
        regulations.setNameKR(regulationsDto.getNameKR());
        regulations.setNameRU(regulationsDto.getNameRU());
        regulations.setCreatedDate(regulationsDto.getCreatedDate());
        AttachmentEntity attachment = regulationsDto.getAttachment();

        AttachDto attachDto=new AttachDto();
        attachDto.setId(attachment.getId());
        attachDto.setLink(serverPath+attachment.getUploadFolder());
        attachDto.setOrginalName(attachment.getOrginalName());
        attachDto.setHashId(attachment.getHashId());
        regulations.setFile(attachDto);

        return regulations;
    }

    @Override
    public Page<RegulationDtoGet> allRegulationgetPage(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        List<Regulations> all = regulationsRepository.findAll();
        List<RegulationDtoGet> allList=new ArrayList<>();
        for (Regulations regulationsDto : all) {
            RegulationDtoGet regulations=new RegulationDtoGet();
            regulations.setId(regulationsDto.getId());
            regulations.setDescriptionRU(regulationsDto.getDescriptionRU());
            regulations.setDescriptionKR(regulationsDto.getDescriptionKR());
            regulations.setDescriptionEN(regulationsDto.getDescriptionEN());
            regulations.setDescriptionUZ(regulationsDto.getDescriptionUZ());
            regulations.setNameEN(regulationsDto.getNameEN());
            regulations.setNameUZ(regulationsDto.getNameUZ());
            regulations.setNameKR(regulationsDto.getNameKR());
            regulations.setNameRU(regulationsDto.getNameRU());
            regulations.setCreatedDate(regulationsDto.getCreatedDate());
            AttachmentEntity attachment = regulationsDto.getAttachment();

            AttachDto attachDto=new AttachDto();
            attachDto.setId(attachment.getId());
            attachDto.setLink(serverPath+attachment.getUploadFolder());
            attachDto.setOrginalName(attachment.getOrginalName());
            attachDto.setHashId(attachment.getHashId());
            regulations.setFile(attachDto);
            allList.add(regulations);
        }
        Page<RegulationDtoGet> pagelist=new PageImpl<>(allList,pageable,allList.size());
        return pagelist;
    }

    @Override
    public List<RegulationDtoGet> allRegulation() {
        List<Regulations> repositoryAll = regulationsRepository.findAll();
        List<RegulationDtoGet> allList=new ArrayList<>();
        for (Regulations regulationsDto : repositoryAll) {
            RegulationDtoGet regulations=new RegulationDtoGet();
            regulations.setId(regulationsDto.getId());
            regulations.setDescriptionRU(regulationsDto.getDescriptionRU());
            regulations.setDescriptionKR(regulationsDto.getDescriptionKR());
            regulations.setDescriptionEN(regulationsDto.getDescriptionEN());
            regulations.setDescriptionUZ(regulationsDto.getDescriptionUZ());
            regulations.setNameEN(regulationsDto.getNameEN());
            regulations.setNameUZ(regulationsDto.getNameUZ());
            regulations.setNameKR(regulationsDto.getNameKR());
            regulations.setNameRU(regulationsDto.getNameRU());
            regulations.setCreatedDate(regulationsDto.getCreatedDate());
            AttachmentEntity attachment = regulationsDto.getAttachment();

            AttachDto attachDto=new AttachDto();
            attachDto.setId(attachment.getId());
            attachDto.setLink(serverPath+attachment.getUploadFolder());
            attachDto.setOrginalName(attachment.getOrginalName());
            attachDto.setHashId(attachment.getHashId());
            regulations.setFile(attachDto);
            allList.add(regulations);
        }
        return allList;
    }
}
