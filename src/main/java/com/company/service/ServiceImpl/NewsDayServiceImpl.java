package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.NewsDay;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.NewsDayRepository;
import com.company.service.NewsDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewsDayServiceImpl implements NewsDayService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private NewsDayRepository newsDayRepository;


    @Override
    public ApiResponse saveNews(NewsDayDto newsDayDto) {
        NewsDay newsDay=new NewsDay();
        newsDay.setTitleRU(newsDayDto.getTitleRU());
        newsDay.setTitleEN(newsDayDto.getTitleEN());
        newsDay.setTitleKR(newsDayDto.getTitleKR());
        newsDay.setTitleUZ(newsDayDto.getTitleUZ());
        newsDay.setDescriptionKR(newsDayDto.getDescriptionKR());
        newsDay.setDescriptionEN(newsDayDto.getDescriptionEN());
        newsDay.setDescriptionRU(newsDayDto.getDescriptionRU());
        newsDay.setDescriptionUZ(newsDayDto.getDescriptionUZ());
        newsDay.setShortdescriptionEN(newsDayDto.getShortdescriptionEN());
        newsDay.setShortdescriptionRU(newsDayDto.getShortdescriptionRU());
        newsDay.setShortdescriptionKR(newsDayDto.getShortdescriptionKR());
        newsDay.setShortdescriptionUZ(newsDayDto.getShortdescriptionUZ());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(newsDayDto.getHashId());

        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }

        newsDay.setImages(optional.get());

        newsDayRepository.save(newsDay);

        return new ApiResponse("add news success", true);
    }

    @Override
    public ApiResponse editNews(Long id, NewsDayDto newsDayDto) {
        Optional<NewsDay> optionalNewsDay = newsDayRepository.findById(id);
        if (!optionalNewsDay.isPresent()){
            return new ApiResponse("not found news Day", false);
        }

        NewsDay newsDay = optionalNewsDay.get();

        newsDay.setTitleRU(newsDayDto.getTitleRU());
        newsDay.setTitleEN(newsDayDto.getTitleEN());
        newsDay.setTitleKR(newsDayDto.getTitleKR());
        newsDay.setTitleUZ(newsDayDto.getTitleUZ());
        newsDay.setDescriptionKR(newsDayDto.getDescriptionKR());
        newsDay.setDescriptionEN(newsDayDto.getDescriptionEN());
        newsDay.setDescriptionRU(newsDayDto.getDescriptionRU());
        newsDay.setDescriptionUZ(newsDayDto.getDescriptionUZ());
        newsDay.setShortdescriptionEN(newsDayDto.getShortdescriptionEN());
        newsDay.setShortdescriptionRU(newsDayDto.getShortdescriptionRU());
        newsDay.setShortdescriptionKR(newsDayDto.getShortdescriptionKR());
        newsDay.setShortdescriptionUZ(newsDayDto.getShortdescriptionUZ());

        Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(newsDayDto.getHashId());

        if (!optional.isPresent()){
            return new ApiResponse("not found image", false);
        }

        newsDay.setImages(optional.get());

        newsDayRepository.save(newsDay);
        return new ApiResponse("edit news Day success", true);
    }

    @Override
    public ApiResponse deleteNews(Long id) {
        try{
            newsDayRepository.deleteById(id);
            return new ApiResponse("delete news Day",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public NewsDay newsById(Long id) {
        Optional<NewsDay> optionalNewsDay = newsDayRepository.findById(id);
        if (!optionalNewsDay.isPresent()){
            return new NewsDay();
        }
        return optionalNewsDay.get();
    }
}
