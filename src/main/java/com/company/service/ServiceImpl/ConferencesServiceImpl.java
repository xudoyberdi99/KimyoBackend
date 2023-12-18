package com.company.service.ServiceImpl;

import com.company.entity.Category;
import com.company.entity.Conferences;
import com.company.payload.ApiResponse;
import com.company.payload.ConferencesDto;
import com.company.repository.CategoryRepository;
import com.company.repository.ConferencesRepository;
import com.company.service.ConferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConferencesServiceImpl implements ConferencesService {

    @Autowired
    private ConferencesRepository conferencesRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ApiResponse conferenceSave(ConferencesDto conferencesDto) {
        Conferences conferences=new Conferences();

        conferences.setAddress(conferencesDto.getAddress());
        conferences.setEmail(conferencesDto.getEmail());
        conferences.setPhone(conferencesDto.getPhone());
        conferences.setSana(conferencesDto.getSana());

        conferences.setDescriptionKR(conferencesDto.getDescriptionKR());
        conferences.setDescriptionEN(conferencesDto.getDescriptionEN());
        conferences.setDescriptionUZ(conferencesDto.getDescriptionUZ());
        conferences.setDescriptionRU(conferencesDto.getDescriptionRU());
        Optional<Category> optionalCategory = categoryRepository.findById(conferencesDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("not found category", false);
        }
        Category category = optionalCategory.get();
        conferences.setCategory(category);

        conferencesRepository.save(conferences);

        return new ApiResponse("add conferense success", true);
    }

    @Override
    public ApiResponse conferenceEdit(Long id, ConferencesDto conferencesDto) {
        Optional<Conferences> optionalConferences = conferencesRepository.findById(id);

        if (!optionalConferences.isPresent()){
            return new ApiResponse("not foun conferense", false);
        }
        Conferences conferences = optionalConferences.get();
        conferences.setAddress(conferencesDto.getAddress());
        conferences.setEmail(conferencesDto.getEmail());
        conferences.setPhone(conferencesDto.getPhone());
        conferences.setSana(conferencesDto.getSana());

        conferences.setDescriptionKR(conferencesDto.getDescriptionKR());
        conferences.setDescriptionEN(conferencesDto.getDescriptionEN());
        conferences.setDescriptionUZ(conferencesDto.getDescriptionUZ());
        conferences.setDescriptionRU(conferencesDto.getDescriptionRU());
        Optional<Category> optionalCategory = categoryRepository.findById(conferencesDto.getCategoryId());
        if (!optionalCategory.isPresent()){
            return new ApiResponse("not found category", false);
        }
        Category category = optionalCategory.get();
        conferences.setCategory(category);
        conferencesRepository.save(conferences);
        return new ApiResponse("edit conferense success", true);
    }

    @Override
    public ApiResponse conferenceDelete(Long id) {
        try{
            conferencesRepository.deleteById(id);
            return new ApiResponse("delete conferense",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public Conferences conferenceGetById(Long id) {
        return conferencesRepository.findById(id).orElse(new Conferences());
    }

    @Override
    public Page<Conferences> allconference(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return conferencesRepository.findAll(pageable);
    }

    @Override
    public Page<Conferences> conferenceGetByCategoryId(Long categoryId, int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return conferencesRepository.findAllByCategory_Id(categoryId,pageable);
    }
}
