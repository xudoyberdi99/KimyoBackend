package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.Partners;
import com.company.payload.ApiResponse;
import com.company.payload.PartnersDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.PartnersRepository;
import com.company.service.PartnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartnersServiceImpl implements PartnersService {
    @Autowired
    private PartnersRepository partnersRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;


    @Override
    public ApiResponse savepartner(PartnersDto partnersDto) {
        Partners partners=new Partners();
        partners.setDescription(partnersDto.getDescription());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(partnersDto.getIcon());
        if (!optional.isPresent()){
            return new ApiResponse("not found icon", false);
        }

        AttachmentEntity attachmentEntity = optional.get();
        partners.setIcon(attachmentEntity);
        partnersRepository.save(partners);
        return new ApiResponse("add partners success",true);
    }

    @Override
    public ApiResponse editpartner(Long id, PartnersDto partnersDto) {
        Optional<Partners> repositoryById = partnersRepository.findById(id);
        if (!repositoryById.isPresent()){
            return  new ApiResponse("not found partners", false);
        }
        Partners partners = repositoryById.get();
        partners.setDescription(partnersDto.getDescription());
        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(partnersDto.getIcon());
        if (!optional.isPresent()){
            return new ApiResponse("not found icon", false);
        }

        AttachmentEntity attachmentEntity = optional.get();
        partners.setIcon(attachmentEntity);
        partnersRepository.save(partners);
        return new ApiResponse("edit partners success",true);
    }

    @Override
    public ApiResponse deletepartner(Long id) {
        try{
            partnersRepository.deleteById(id);
            return new ApiResponse("delete partners",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Partners partnerById(Long id) {
        return partnersRepository.findById(id).orElse(new Partners());
    }

    @Override
    public Page<Partners> getAllpartner(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return partnersRepository.findAll(pageable);
    }
}
