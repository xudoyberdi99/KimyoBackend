package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.OpenDataGetDto;
import com.company.dto.RegulationDtoGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.OpenData;
import com.company.payload.ApiResponse;
import com.company.payload.OpenDataDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.OpenDataRepository;
import com.company.service.OpenDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OpenDataServiceImpl implements OpenDataService {
    @Autowired
    private OpenDataRepository openDataRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Value("${upload.server}")
    private String serverPath;
    @Override
    public ApiResponse addOpendata(OpenDataDto openDataDto) {
        OpenData openData=new OpenData();
        openData.setNameUZ(openDataDto.getNameUZ());
        openData.setNameRU(openDataDto.getNameRU());
        openData.setNameEN(openDataDto.getNameEN());
        openData.setNameKR(openDataDto.getNameKR());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(openDataDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found file",false);
        }
        openData.setAttachment(optional.get());
        openDataRepository.save(openData);
        return new ApiResponse("add open data success", true);
    }

    @Override
    public ApiResponse editOpendata(Long id, OpenDataDto openDataDto) {
        Optional<OpenData> optionalOpenData = openDataRepository.findById(id);
        if (!optionalOpenData.isPresent()){
            return new ApiResponse("not found open data", false);
        }
        OpenData openData = optionalOpenData.get();
        openData.setNameUZ(openDataDto.getNameUZ());
        openData.setNameRU(openDataDto.getNameRU());
        openData.setNameEN(openDataDto.getNameEN());
        openData.setNameKR(openDataDto.getNameKR());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(openDataDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found file",false);
        }
        openData.setAttachment(optional.get());
        openDataRepository.save(openData);
        return new ApiResponse("edit open data success", true);
    }

    @Override
    public ApiResponse deleteOpendata(Long id) {
        try{
            openDataRepository.deleteById(id);
            return new ApiResponse("delete open data",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public OpenDataGetDto OpendatagetByid(Long id) {
        Optional<OpenData> optionalOpenData = openDataRepository.findById(id);
        if (!optionalOpenData.isPresent()){
            return new OpenDataGetDto();
        }
        OpenData openData = optionalOpenData.get();
        OpenDataGetDto openDataGetDto=new OpenDataGetDto();
        openDataGetDto.setId(openData.getId());
        openDataGetDto.setNameUZ(openData.getNameUZ());
        openDataGetDto.setNameKR(openData.getNameKR());
        openDataGetDto.setNameEN(openData.getNameEN());
        openDataGetDto.setNameRU(openData.getNameRU());
        AttachmentEntity attachment = openData.getAttachment();
        AttachDto attachDto=new AttachDto();
        attachDto.setId(attachment.getId());
        attachDto.setLink(serverPath+attachment.getUploadFolder());
        attachDto.setOrginalName(attachment.getOrginalName());
        attachDto.setHashId(attachment.getHashId());
        openDataGetDto.setFile(attachDto);
        return openDataGetDto;
    }

    @Override
    public List<OpenDataGetDto> allOpendata() {
        List<OpenData> all = openDataRepository.findAll();
        List<OpenDataGetDto> getall=new ArrayList<>();
        for (OpenData openData : all) {
            OpenDataGetDto openDataGetDto=new OpenDataGetDto();
            openDataGetDto.setId(openData.getId());
            openDataGetDto.setNameUZ(openData.getNameUZ());
            openDataGetDto.setNameKR(openData.getNameKR());
            openDataGetDto.setNameEN(openData.getNameEN());
            openDataGetDto.setNameRU(openData.getNameRU());
            AttachmentEntity attachment = openData.getAttachment();
            AttachDto attachDto=new AttachDto();
            attachDto.setId(attachment.getId());
            attachDto.setLink(serverPath+attachment.getUploadFolder());
            attachDto.setOrginalName(attachment.getOrginalName());
            attachDto.setHashId(attachment.getHashId());
            openDataGetDto.setFile(attachDto);
            getall.add(openDataGetDto);
        }
        return getall;
    }
}
