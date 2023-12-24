package com.company.service.ServiceImpl;

import com.company.dto.AttachDto;
import com.company.dto.NewsGetDto;
import com.company.entity.AboutInstituti;
import com.company.entity.AttachmentEntity;
import com.company.entity.Category;
import com.company.entity.News;
import com.company.payload.ApiResponse;
import com.company.payload.NewsDayDto;
import com.company.payload.NewsDto;
import com.company.repository.AttachmentRepository;
import com.company.repository.CategoryRepository;
import com.company.repository.NewsRepository;
import com.company.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Value("${upload.server}")
    private String serverPath;

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
    public NewsGetDto newsById(Long id) {
        Optional<News> newsOptional = newsRepository.findById(id);
        if (!newsOptional.isPresent()){
            return null;
        }
        News newsDto = newsOptional.get();
        NewsGetDto news=new NewsGetDto();

        news.setId(newsDto.getId());
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

        List<AttachmentEntity> images = newsDto.getImages();
        List<AttachDto> imageslist=new ArrayList<>();

        for (AttachmentEntity image : images) {
            AttachDto attachDto=new AttachDto();
            attachDto.setOrginalName(image.getOrginalName());
            attachDto.setId(image.getId());
            attachDto.setLink(serverPath+image.getUploadFolder());
            attachDto.setHashId(image.getHashId());
            imageslist.add(attachDto);
        }
        news.setImages(imageslist);

        return news;
    }

    @Override
    public Page<NewsGetDto> getAllServices(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        List<News> repositoryAll = newsRepository.findAll();
        List<NewsGetDto> allListNews=new ArrayList<>();
        for (News newsDto : repositoryAll) {
            NewsGetDto news=new NewsGetDto();
            news.setId(newsDto.getId());
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

            List<AttachmentEntity> images = newsDto.getImages();
            List<AttachDto> imageslist=new ArrayList<>();

            for (AttachmentEntity image : images) {
                AttachDto attachDto=new AttachDto();
                attachDto.setOrginalName(image.getOrginalName());
                attachDto.setId(image.getId());
                attachDto.setLink(serverPath+image.getUploadFolder());
                attachDto.setHashId(image.getHashId());
                imageslist.add(attachDto);
            }
            news.setImages(imageslist);

            allListNews.add(news);
        }
        Page<NewsGetDto> pagelist=new PageImpl<>(allListNews,pageable,allListNews.size());

        return pagelist;
    }

    @Override
    public List<NewsGetDto> allnewsByList(){
        List<News> repositoryAll = newsRepository.findAll();
        List<NewsGetDto> allListNews=new ArrayList<>();
        for (News newsDto : repositoryAll) {
            NewsGetDto news=new NewsGetDto();
            news.setId(newsDto.getId());
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

            List<AttachmentEntity> images = newsDto.getImages();
            List<AttachDto> imageslist=new ArrayList<>();

            for (AttachmentEntity image : images) {
                AttachDto attachDto=new AttachDto();
                attachDto.setOrginalName(image.getOrginalName());
                attachDto.setId(image.getId());
                attachDto.setLink(serverPath+image.getUploadFolder());
                attachDto.setHashId(image.getHashId());
                imageslist.add(attachDto);
            }
            news.setImages(imageslist);
            allListNews.add(news);
        }


        return allListNews;
    }
}
