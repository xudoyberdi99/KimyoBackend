package com.company.service.ServiceImpl;

import com.company.controller.RequisitesController;
import com.company.entity.Requisites;
import com.company.payload.ApiResponse;
import com.company.payload.RequisitesDto;
import com.company.repository.RegulationsRepository;
import com.company.repository.RequisitesRepository;
import com.company.service.RequisitesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RequisitesServiceImpl implements RequisitesService {
    @Autowired
    private RequisitesRepository requisitesRepository;

    @Override
    public ApiResponse Requisitesave(RequisitesDto requisitesDto) {
        Requisites requisites=new Requisites();
        requisites.setContentEN(requisitesDto.getContentEN());
        requisites.setContentUZ(requisitesDto.getContentUZ());
        requisites.setContentKR(requisitesDto.getContentKR());
        requisites.setContentRU(requisitesDto.getContentRU());
        requisitesRepository.save(requisites);
        return new ApiResponse("add requisit success",true);
    }

    @Override
    public ApiResponse editRequisite(Long id, RequisitesDto requisitesDto) {
        Optional<Requisites> requisitesOptional = requisitesRepository.findById(id);
        if (!requisitesOptional.isPresent()){
            return new ApiResponse("not found reuisit", false);
        }
        Requisites requisites = requisitesOptional.get();
        requisites.setContentEN(requisitesDto.getContentEN());
        requisites.setContentUZ(requisitesDto.getContentUZ());
        requisites.setContentKR(requisitesDto.getContentKR());
        requisites.setContentRU(requisitesDto.getContentRU());
        requisitesRepository.save(requisites);
        return new ApiResponse("edit Rekvizit success", true);
    }

    @Override
    public ApiResponse deleteRequisite(Long id) {
        try{
            requisitesRepository.deleteById(id);
            return new ApiResponse("delete requisit",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Requisites requisiteById(Long id) {
        return requisitesRepository.findById(id).orElse(new Requisites());
    }
}
