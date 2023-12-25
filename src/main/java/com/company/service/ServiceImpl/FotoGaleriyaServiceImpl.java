package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.FotoGaleryaDtoGet;
import com.company.entity.AttachmentEntity;
import com.company.entity.FotoGaleriya;
import com.company.payload.ApiResponse;
import com.company.payload.FotoGaleriyaDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.FotoGaleriyaRepository;
import com.company.service.FotoGaleriyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FotoGaleriyaServiceImpl implements FotoGaleriyaService {
    @Autowired
    private FotoGaleriyaRepository fotoGaleriyaRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Value("${upload.server}")
    private String serverPath;
    @Override
    public ApiResponse addFile(FotoGaleriyaDto fotoGaleriyaDto) {
        FotoGaleriya fotoGaleriya=new FotoGaleriya();
        fotoGaleriya.setTitleRU(fotoGaleriyaDto.getTitleRU());
        fotoGaleriya.setTitleUZ(fotoGaleriyaDto.getTitleUZ());
        fotoGaleriya.setTitleKR(fotoGaleriyaDto.getTitleKR());
        fotoGaleriya.setTitleEN(fotoGaleriyaDto.getTitleEN());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(fotoGaleriyaDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found image",false);
        }
        AttachmentEntity attachmentEntity = optional.get();
        fotoGaleriya.setHashId(attachmentEntity);

        fotoGaleriyaRepository.save(fotoGaleriya);

        return new ApiResponse("add file success", true);
    }

    @Override
    public ApiResponse editFile(Long id, FotoGaleriyaDto fotoGaleriyaDto) {
        Optional<FotoGaleriya> fotoGaleriyaOptional = fotoGaleriyaRepository.findById(id);
        if (!fotoGaleriyaOptional.isPresent()){
            return new ApiResponse("not found fotogaleriya", false);
        }
        FotoGaleriya fotoGaleriya = fotoGaleriyaOptional.get();
        fotoGaleriya.setTitleRU(fotoGaleriyaDto.getTitleRU());
        fotoGaleriya.setTitleUZ(fotoGaleriyaDto.getTitleUZ());
        fotoGaleriya.setTitleKR(fotoGaleriyaDto.getTitleKR());
        fotoGaleriya.setTitleEN(fotoGaleriyaDto.getTitleEN());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(fotoGaleriyaDto.getHashId());
        if (!optional.isPresent()){
            return new ApiResponse("not found image",false);
        }
        AttachmentEntity attachmentEntity = optional.get();
        fotoGaleriya.setHashId(attachmentEntity);

        fotoGaleriyaRepository.save(fotoGaleriya);

        return new ApiResponse("edit file success", true);
    }

    @Override
    public ApiResponse deleteFoto(Long id) {
        try{
            fotoGaleriyaRepository.deleteById(id);
            return new ApiResponse("delete file",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public FotoGaleryaDtoGet fotogetByid(Long id) {
        Optional<FotoGaleriya> fotoGaleriyaRepositoryById = fotoGaleriyaRepository.findById(id);
        if (!fotoGaleriyaRepositoryById.isPresent()){
            return new FotoGaleryaDtoGet();
        }
        FotoGaleriya fotoGaleriyaDto = fotoGaleriyaRepositoryById.get();

        FotoGaleryaDtoGet fotoGaleriya=new FotoGaleryaDtoGet();
        fotoGaleriya.setId(fotoGaleriyaDto.getId());
        fotoGaleriya.setTitleRU(fotoGaleriyaDto.getTitleRU());
        fotoGaleriya.setTitleUZ(fotoGaleriyaDto.getTitleUZ());
        fotoGaleriya.setTitleKR(fotoGaleriyaDto.getTitleKR());
        fotoGaleriya.setTitleEN(fotoGaleriyaDto.getTitleEN());

        AttachmentEntity attachment = fotoGaleriyaDto.getHashId();
        AttachDto attachDto=new AttachDto();
        attachDto.setHashId(attachment.getHashId());
        attachDto.setLink(serverPath+attachment.getUploadFolder());
        attachDto.setOrginalName(attachment.getOrginalName());
        attachDto.setId(attachment.getId());

        fotoGaleriya.setImages(attachDto);

        return fotoGaleriya;
    }

    @Override
    public Page<FotoGaleriya> allFoto(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return fotoGaleriyaRepository.findAll(pageable);
    }

    @Override
    public List<FotoGaleryaDtoGet> allFotos() {
        List<FotoGaleriya> galeriyaRepositoryAll = fotoGaleriyaRepository.findAll();
        List<FotoGaleryaDtoGet> gets =new ArrayList<>();
        for (FotoGaleriya fotoGaleriyaDto : galeriyaRepositoryAll) {
            FotoGaleryaDtoGet fotoGaleriya=new FotoGaleryaDtoGet();
            fotoGaleriya.setId(fotoGaleriyaDto.getId());
            fotoGaleriya.setTitleRU(fotoGaleriyaDto.getTitleRU());
            fotoGaleriya.setTitleUZ(fotoGaleriyaDto.getTitleUZ());
            fotoGaleriya.setTitleKR(fotoGaleriyaDto.getTitleKR());
            fotoGaleriya.setTitleEN(fotoGaleriyaDto.getTitleEN());

            AttachmentEntity attachment = fotoGaleriyaDto.getHashId();
            AttachDto attachDto=new AttachDto();
            attachDto.setHashId(attachment.getHashId());
            attachDto.setLink(serverPath+attachment.getUploadFolder());
            attachDto.setOrginalName(attachment.getOrginalName());
            attachDto.setId(attachment.getId());

            fotoGaleriya.setImages(attachDto);

            gets.add(fotoGaleriya);
        }

        return gets;
    }
}
