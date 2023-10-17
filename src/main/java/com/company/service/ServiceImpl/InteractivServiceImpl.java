package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.InteraktivService;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.InteraktivServiceDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.InteractiveServiceRepository;
import com.company.service.InteraktivServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteractivServiceImpl implements InteraktivServices {

    @Autowired
    private InteractiveServiceRepository interactiveServiceRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse addinteractiveService(InteraktivServiceDto interaktivServiceDto) {

        InteraktivService interaktivService=new InteraktivService();

        interaktivService.setLink(interaktivServiceDto.getLink());
        interaktivService.setDescriptionEN(interaktivServiceDto.getDescriptionEN());
        interaktivService.setDescriptionUZ(interaktivServiceDto.getDescriptionUZ());
        interaktivService.setDescriptionRU(interaktivServiceDto.getDescriptionRU());
        interaktivService.setDescriptionKR(interaktivServiceDto.getDescriptionKR());
        interaktivService.setNameEN(interaktivServiceDto.getNameEN());
        interaktivService.setNameKR(interaktivServiceDto.getNameKR());
        interaktivService.setNameUZ(interaktivServiceDto.getNameUZ());
        interaktivService.setNameRU(interaktivServiceDto.getNameRU());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(interaktivServiceDto.getIcon());
        if (!optional.isPresent()){
            return new ApiResponse("not found icon", false);
        }

        interaktivService.setIcon(optional.get());

        interactiveServiceRepository.save(interaktivService);
        return new ApiResponse("add service success",true);
    }

    @Override
    public ApiResponse editinteractiveService(Long id, InteraktivServiceDto interaktivServiceDto) {
        Optional<InteraktivService> service = interactiveServiceRepository.findById(id);
        if(!service.isPresent()){
            return new ApiResponse("not found service", false);
        }

        InteraktivService interaktivService = service.get();

        interaktivService.setLink(interaktivServiceDto.getLink());
        interaktivService.setDescriptionEN(interaktivServiceDto.getDescriptionEN());
        interaktivService.setDescriptionUZ(interaktivServiceDto.getDescriptionUZ());
        interaktivService.setDescriptionRU(interaktivServiceDto.getDescriptionRU());
        interaktivService.setDescriptionKR(interaktivServiceDto.getDescriptionKR());
        interaktivService.setNameEN(interaktivServiceDto.getNameEN());
        interaktivService.setNameKR(interaktivServiceDto.getNameKR());
        interaktivService.setNameUZ(interaktivServiceDto.getNameUZ());
        interaktivService.setNameRU(interaktivServiceDto.getNameRU());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(interaktivServiceDto.getIcon());
        if (!optional.isPresent()){
            return new ApiResponse("not found icon", false);
        }

        interaktivService.setIcon(optional.get());

        interactiveServiceRepository.save(interaktivService);

        return new ApiResponse("edit service success",true);
    }

    @Override
    public ApiResponse deleteinteractiveService(Long id) {
        try{
            interactiveServiceRepository.deleteById(id);
            return new ApiResponse("delete service",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public InteraktivService getinteractiveService(Long id) {
        Optional<InteraktivService> service = interactiveServiceRepository.findById(id);
        if (!service.isPresent()){
            return new InteraktivService();
        }
        return service.get();
    }

    @Override
    public Page<InteraktivService> getAllServices(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return interactiveServiceRepository.findAll(pageable);
    }
}
