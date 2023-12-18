package com.company.service.ServiceImpl;

import com.company.dto.AboutInstitutGetDto;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Value("${upload.server}")
    private String serverPath;

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
    @Transactional
    public AboutInstitutGetDto AboutGetById(Long id) {
        Optional<AboutInstituti> aboutInstituti = aboutInstitutiRepository.findById(id);
        if (!aboutInstituti.isPresent()){
            return new AboutInstitutGetDto();
        }
        AboutInstituti aboutInstituti1 = aboutInstituti.get();
        AboutInstitutGetDto aboutInstitutGetDto=new AboutInstitutGetDto();
        aboutInstitutGetDto.setDescriptionKR(aboutInstituti1.getDescriptionKR());
        aboutInstitutGetDto.setDescriptionEN(aboutInstituti1.getDescriptionEN());
        aboutInstitutGetDto.setDescriptionRU(aboutInstituti1.getDescriptionRU());
        aboutInstitutGetDto.setDescriptionUZ(aboutInstituti1.getDescriptionUZ());
        aboutInstitutGetDto.setShortdescriptionEN(aboutInstituti1.getShortdescriptionEN());
        aboutInstitutGetDto.setShortdescriptionUZ(aboutInstituti1.getShortdescriptionUZ());
        aboutInstitutGetDto.setShortdescriptionRU(aboutInstituti1.getShortdescriptionRU());
        aboutInstitutGetDto.setShortdescriptionKR(aboutInstituti1.getShortdescriptionKR());
        aboutInstitutGetDto.setTitleEN(aboutInstituti1.getTitleEN());
        aboutInstitutGetDto.setTitleRU(aboutInstituti1.getTitleRU());
        aboutInstitutGetDto.setTitleKR(aboutInstituti1.getTitleKR());
        aboutInstitutGetDto.setTitleUZ(aboutInstituti1.getTitleUZ());

        Category category = aboutInstituti1.getCategory();
        aboutInstitutGetDto.setCategoryid(category.getId());

        List<AttachmentEntity> images = aboutInstituti1.getImages();
        List<String> link=new ArrayList<>();
        for (AttachmentEntity image : images) {
            link.add(serverPath+image.getUploadFolder());
        }
        aboutInstitutGetDto.setImages(link);

        return aboutInstitutGetDto;
    }

    @Override
    @Transactional
    public AboutInstitutGetDto getByCategoryIdAboutInstituti(Long categoryid) {
        AboutInstituti aboutInstituti1 = aboutInstitutiRepository.getbyCategoryid(categoryid);

        AboutInstitutGetDto aboutInstitutGetDto=new AboutInstitutGetDto();
        aboutInstitutGetDto.setDescriptionKR(aboutInstituti1.getDescriptionKR());
        aboutInstitutGetDto.setDescriptionEN(aboutInstituti1.getDescriptionEN());
        aboutInstitutGetDto.setDescriptionRU(aboutInstituti1.getDescriptionRU());
        aboutInstitutGetDto.setDescriptionUZ(aboutInstituti1.getDescriptionUZ());
        aboutInstitutGetDto.setShortdescriptionEN(aboutInstituti1.getShortdescriptionEN());
        aboutInstitutGetDto.setShortdescriptionUZ(aboutInstituti1.getShortdescriptionUZ());
        aboutInstitutGetDto.setShortdescriptionRU(aboutInstituti1.getShortdescriptionRU());
        aboutInstitutGetDto.setShortdescriptionKR(aboutInstituti1.getShortdescriptionKR());
        aboutInstitutGetDto.setTitleEN(aboutInstituti1.getTitleEN());
        aboutInstitutGetDto.setTitleRU(aboutInstituti1.getTitleRU());
        aboutInstitutGetDto.setTitleKR(aboutInstituti1.getTitleKR());
        aboutInstitutGetDto.setTitleUZ(aboutInstituti1.getTitleUZ());

        Category category = aboutInstituti1.getCategory();
        aboutInstitutGetDto.setCategoryid(category.getId());

        List<AttachmentEntity> images = aboutInstituti1.getImages();
        List<String> link=new ArrayList<>();
        for (AttachmentEntity image : images) {
            link.add(serverPath+image.getUploadFolder());
        }
        aboutInstitutGetDto.setImages(link);

        return aboutInstitutGetDto;
    }
}
