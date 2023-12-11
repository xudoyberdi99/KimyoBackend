package com.company.service.ServiceImpl;

import com.company.entity.AboutInstituti;
import com.company.entity.AttachmentEntity;
import com.company.entity.Category;
import com.company.payload.AboutInstitutiDto;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.repository.AboutInstitutiRepository;
import com.company.repository.AttachmentRepository;
import com.company.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.*;

@Service
public class AboutInstitutiService implements com.company.service.AboutInstitutiService {
    @Autowired
    private AboutInstitutiRepository aboutInstitutiRepository;
    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ApiResponse AboutInstitutiSave(@Valid AboutInstitutiDto aboutInstitutiDto) {
        AboutInstituti aboutInstituti=new AboutInstituti();

        aboutInstituti.setDescriptionRU(aboutInstitutiDto.getDescriptionRU());
        aboutInstituti.setDescriptionKR(aboutInstitutiDto.getDescriptionKR());
        aboutInstituti.setDescriptionEN(aboutInstitutiDto.getDescriptionEN());
        aboutInstituti.setDescriptionUZ(aboutInstitutiDto.getDescriptionUZ());
        aboutInstituti.setShortdescriptionEN(aboutInstitutiDto.getShortdescriptionEN());
        aboutInstituti.setShortdescriptionKR(aboutInstitutiDto.getShortdescriptionKR());
        aboutInstituti.setShortdescriptionRU(aboutInstitutiDto.getShortdescriptionRU());
        aboutInstituti.setShortdescriptionUZ(aboutInstitutiDto.getShortdescriptionUZ());
        aboutInstituti.setTitleEN(aboutInstitutiDto.getTitleEN());
        aboutInstituti.setTitleRU(aboutInstitutiDto.getTitleRU());
        aboutInstituti.setTitleKR(aboutInstitutiDto.getTitleKR());
        aboutInstituti.setTitleUZ(aboutInstitutiDto.getTitleUZ());

        List<String> images1 = aboutInstitutiDto.getImages();
        List<AttachmentEntity> images=new ArrayList<>();
        for (String s : images1) {
            Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(s);
            if (optional.isPresent()){
                images.add(optional.get());
            }
        }
        aboutInstituti.setImages(images);
        Optional<Category> categoryOptional = categoryRepository.findById(aboutInstitutiDto.getCategoryid());
        if (!categoryOptional.isPresent()){
            return new ApiResponse("not found category", false);
        }
        aboutInstituti.setCategory(categoryOptional.get());
        aboutInstitutiRepository.save(aboutInstituti);
        return new ApiResponse(" add about instituti success", true);
    }

    @Override
    public ApiResponse editAboutInstituti(Long id, AboutInstitutiDto aboutInstitutiDto) {
        Optional<AboutInstituti> aboutInstitutiop = aboutInstitutiRepository.findById(id);
        if (!aboutInstitutiop.isPresent()){
            return new ApiResponse("not found about instituti", false);
        }

        AboutInstituti aboutInstituti = aboutInstitutiop.get();

        aboutInstituti.setDescriptionRU(aboutInstitutiDto.getDescriptionRU());
        aboutInstituti.setDescriptionKR(aboutInstitutiDto.getDescriptionKR());
        aboutInstituti.setDescriptionEN(aboutInstitutiDto.getDescriptionEN());
        aboutInstituti.setDescriptionUZ(aboutInstitutiDto.getDescriptionUZ());
        aboutInstituti.setShortdescriptionEN(aboutInstitutiDto.getShortdescriptionEN());
        aboutInstituti.setShortdescriptionKR(aboutInstitutiDto.getShortdescriptionKR());
        aboutInstituti.setShortdescriptionRU(aboutInstitutiDto.getShortdescriptionRU());
        aboutInstituti.setShortdescriptionUZ(aboutInstitutiDto.getShortdescriptionUZ());
        aboutInstituti.setTitleEN(aboutInstitutiDto.getTitleEN());
        aboutInstituti.setTitleRU(aboutInstitutiDto.getTitleRU());
        aboutInstituti.setTitleKR(aboutInstitutiDto.getTitleKR());
        aboutInstituti.setTitleUZ(aboutInstitutiDto.getTitleUZ());

        List<String> images1 = aboutInstitutiDto.getImages();
        List<AttachmentEntity> images=new ArrayList<>();
        for (String s : images1) {
            Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(s);
            if (optional.isPresent()){
                images.add(optional.get());
            }
        }
        aboutInstituti.setImages(images);
        Optional<Category> categoryOptional = categoryRepository.findById(aboutInstitutiDto.getCategoryid());
        if (!categoryOptional.isPresent()){
            return new ApiResponse("not found category", false);
        }
        aboutInstituti.setCategory(categoryOptional.get());
        aboutInstitutiRepository.save(aboutInstituti);

        return new ApiResponse("edit about instituti success", true);
    }

    @Override
    public ApiResponse deleteAbout(Long id) {
        try{
            aboutInstitutiRepository.deleteById(id);
            return new ApiResponse("delete about instituti",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public AboutInstituti AboutGetById(Long id) {
        return aboutInstitutiRepository.findById(id).orElse(new AboutInstituti());
    }

    @Override
    public AboutInstituti getByCategoryIdAboutInstituti(Long categoryid) {
        return aboutInstitutiRepository.findByCategory_Id(categoryid).orElse(new AboutInstituti());
    }
}
