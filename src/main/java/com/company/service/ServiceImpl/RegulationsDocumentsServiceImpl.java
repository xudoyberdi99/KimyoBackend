package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.RegulationDtoGet;
import com.company.dto.RegulatoryDocumentsDtoGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.Regulations;
import com.company.entity.RegulatoryDocuments;
import com.company.payload.ApiResponse;
import com.company.payload.RegulatoryDocumentsDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.RegulationsDocumentsRepository;
import com.company.service.RegulationsDocumentsService;
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
public class RegulationsDocumentsServiceImpl implements RegulationsDocumentsService {
    @Autowired
    private RegulationsDocumentsRepository regulationsDocumentsRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

    @Value("${upload.server}")
    private String serverPath;
    @Override
    public ApiResponse addRegulationdocument(RegulatoryDocumentsDto regulationsDto) {
        RegulatoryDocuments regulations=new RegulatoryDocuments();
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
        regulationsDocumentsRepository.save(regulations);
        return new ApiResponse("regulationdocument add success",true);
    }

    @Override
    public ApiResponse editRegulationdocument(Long id, RegulatoryDocumentsDto regulationsDto) {
        Optional<RegulatoryDocuments> regulationsRepositoryById = regulationsDocumentsRepository.findById(id);
        if (!regulationsRepositoryById.isPresent()){
            return new ApiResponse("not found regulardocument", false);
        }
        RegulatoryDocuments regulations = regulationsRepositoryById.get();
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
        regulationsDocumentsRepository.save(regulations);
        return new ApiResponse("regulationdocument edit success",true);
    }

    @Override
    public ApiResponse deleteRegulationdocument(Long id) {
        try{
            regulationsDocumentsRepository.deleteById(id);
            return new ApiResponse("delete regulationdocument",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public RegulatoryDocumentsDtoGet regulationdocumentByid(Long id) {
        Optional<RegulatoryDocuments> regulationsRepositoryById = regulationsDocumentsRepository.findById(id);
        if (!regulationsRepositoryById.isPresent()){
            return new RegulatoryDocumentsDtoGet();
        }
        RegulatoryDocuments regulationsDto = regulationsRepositoryById.get();
        RegulatoryDocumentsDtoGet regulations=new RegulatoryDocumentsDtoGet();
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
    public Page<RegulatoryDocumentsDtoGet> allregulationdocumentPage(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        List<RegulatoryDocuments> all = regulationsDocumentsRepository.findAll();
        List<RegulatoryDocumentsDtoGet> allList=new ArrayList<>();
        for (RegulatoryDocuments regulationsDto : all) {
            RegulatoryDocumentsDtoGet regulations=new RegulatoryDocumentsDtoGet();
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
        Page<RegulatoryDocumentsDtoGet> pagelist=new PageImpl<>(allList,pageable,allList.size());
        return pagelist;
    }

    @Override
    public List<RegulatoryDocumentsDtoGet> regulationdocument() {
        List<RegulatoryDocuments> repositoryAll = regulationsDocumentsRepository.findAll();
        List<RegulatoryDocumentsDtoGet> allList=new ArrayList<>();
        for (RegulatoryDocuments regulationsDto : repositoryAll) {
            RegulatoryDocumentsDtoGet regulations=new RegulatoryDocumentsDtoGet();
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
