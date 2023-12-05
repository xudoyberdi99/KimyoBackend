package com.company.service.ServiceImpl;

import com.company.entity.Category;
import com.company.entity.Conferences;
import com.company.entity.GeneralPage;
import com.company.payload.ApiResponse;
import com.company.payload.GeneralPageDto;
import com.company.repository.CategoryRepository;
import com.company.repository.GeneralPageRepository;
import com.company.service.GeneralPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralPageServiceImpl implements GeneralPageService {
        @Autowired
        private GeneralPageRepository generalPageRepository;
        @Autowired
        private CategoryRepository categoryRepository;


    @Override
    public ApiResponse addgeneralpage(GeneralPageDto generalPageDto) {
        GeneralPage generalPage=new GeneralPage();
        generalPage.setDescriptionKR(generalPageDto.getDescriptionKR());
        generalPage.setDescriptionEN(generalPageDto.getDescriptionEN());
        generalPage.setDescriptionUZ(generalPageDto.getDescriptionUZ());
        generalPage.setDescriptionRU(generalPageDto.getDescriptionRU());
        Optional<Category> categoryOptional = categoryRepository.findById(generalPageDto.getCategoryId());
        if (!categoryOptional.isPresent()){
            return new ApiResponse("not found category",false);
        }
        generalPage.setCategory(categoryOptional.get());
        generalPageRepository.save(generalPage);
        return new ApiResponse("add page success", true);
    }

    @Override
    public ApiResponse editGeneralPage(Long id, GeneralPageDto generalPageDto) {
        Optional<GeneralPage> repositoryById = generalPageRepository.findById(id);
        if (!repositoryById.isPresent()){
            return new ApiResponse("not found repository", false);
        }
        GeneralPage generalPage = repositoryById.get();
        generalPage.setDescriptionKR(generalPageDto.getDescriptionKR());
        generalPage.setDescriptionEN(generalPageDto.getDescriptionEN());
        generalPage.setDescriptionUZ(generalPageDto.getDescriptionUZ());
        generalPage.setDescriptionRU(generalPageDto.getDescriptionRU());
        Optional<Category> categoryOptional = categoryRepository.findById(generalPageDto.getCategoryId());
        if (!categoryOptional.isPresent()){
            return new ApiResponse("not found category",false);
        }
        generalPage.setCategory(categoryOptional.get());
        generalPageRepository.save(generalPage);
        return new ApiResponse("edit page success", true);
    }

    @Override
    public ApiResponse generalpageDelete(Long id) {
        try{
            generalPageRepository.deleteById(id);
            return new ApiResponse("delete service",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public GeneralPage generalPageGetById(Long id) {
        return generalPageRepository.findById(id).orElse(new GeneralPage());
    }

    @Override
    public List<GeneralPage> generalPageGetBycategory(Long categoryid) {
        return generalPageRepository.findAllByCategory_Id(categoryid);
    }
}
