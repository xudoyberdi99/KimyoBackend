package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.FotoGaleriya;
import com.company.payload.ApiResponse;
import com.company.payload.FotoGaleriyaDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.FotoGaleriyaRepository;
import com.company.service.FotoGaleriyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoGaleriyaServiceImpl implements FotoGaleriyaService {
    @Autowired
    private FotoGaleriyaRepository fotoGaleriyaRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;

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

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(String.valueOf(fotoGaleriyaDto.getHashId()));
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
    public FotoGaleriya fotogetByid(Long id) {
        return fotoGaleriyaRepository.findById(id).orElse(new FotoGaleriya());
    }

    @Override
    public Page<FotoGaleriya> allFoto(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return fotoGaleriyaRepository.findAll(pageable);
    }
}
