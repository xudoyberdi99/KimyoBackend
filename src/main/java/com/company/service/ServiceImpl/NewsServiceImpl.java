package com.company.service.ServiceImpl;

import com.company.entity.AboutInstituti;
import com.company.entity.AttachmentEntity;
import com.company.entity.News;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.payload.NewsDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.NewsRepository;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Override
    public ApiResponse saveNews(NewsDto newsDto) {

        News news =new News();
        news.setTitleRU(newsDto.getTitleRU());
        news.setTitleEN(newsDto.getTitleEN());
        news.setTitleKR(newsDto.getTitleKR());
        news.setTitleUZ(newsDto.getTitleUZ());
        news.setDescriptionKR(newsDto.getDescriptionKR());
        news.setDescriptionEN(newsDto.getDescriptionEN());
        news.setDescriptionRU(newsDto.getDescriptionRU());
        news.setDescriptionUZ(newsDto.getDescriptionUZ());
        news.setShortdescriptionEN(newsDto.getShortdescriptionEN());
        news.setShortdescriptionRU(newsDto.getShortdescriptionRU());
        news.setShortdescriptionKR(newsDto.getShortdescriptionKR());
        news.setShortdescriptionUZ(newsDto.getShortdescriptionUZ());

        List<String> images1 = newsDto.getHashIds();
        List<AttachmentEntity> images=new ArrayList<>();
        for (String s : images1) {
            Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(s);
            if (optional.isPresent()){
                images.add(optional.get());
            }
        }
        news.setImages(images);

        newsRepository.save(news);
        return new ApiResponse("add news success", true);
    }

    @Override
    public ApiResponse editNews(Long id, NewsDto newsDto) {
        Optional<News> newsOptional = newsRepository.findById(id);
        if (!newsOptional.isPresent()){
            return  new ApiResponse("not found news", false);
        }
        News news = newsOptional.get();

        news.setTitleRU(newsDto.getTitleRU());
        news.setTitleEN(newsDto.getTitleEN());
        news.setTitleKR(newsDto.getTitleKR());
        news.setTitleUZ(newsDto.getTitleUZ());
        news.setDescriptionKR(newsDto.getDescriptionKR());
        news.setDescriptionEN(newsDto.getDescriptionEN());
        news.setDescriptionRU(newsDto.getDescriptionRU());
        news.setDescriptionUZ(newsDto.getDescriptionUZ());
        news.setShortdescriptionEN(newsDto.getShortdescriptionEN());
        news.setShortdescriptionRU(newsDto.getShortdescriptionRU());
        news.setShortdescriptionKR(newsDto.getShortdescriptionKR());
        news.setShortdescriptionUZ(newsDto.getShortdescriptionUZ());

        List<String> images1 = newsDto.getHashIds();
        List<AttachmentEntity> images=new ArrayList<>();
        for (String s : images1) {
            Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(s);
            if (optional.isPresent()){
                images.add(optional.get());
            }
        }
        news.setImages(images);
        newsRepository.save(news);
        return new ApiResponse("edit news success", true);
    }

    @Override
    public ApiResponse deleteNews(Long id) {
        try{
            newsRepository.deleteById(id);
            return new ApiResponse("delete news",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public News newsById(Long id) {
        return newsRepository.findById(id).orElse(new News());
    }

    @Override
    public Page<News> getAllServices(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        return newsRepository.findAll(pageable);
    }
}
