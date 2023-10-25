package com.company.service.ServiceImpl;

import com.company.entity.AttachmentEntity;
import com.company.entity.News;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.payload.NewsDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.NewsRepository;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @Override
    public ApiResponse deleteNews(Long id) {
        return null;
    }

    @Override
    public News newsById(Long id) {
        return null;
    }

    @Override
    public List<News> Allnews() {
        return null;
    }
}
