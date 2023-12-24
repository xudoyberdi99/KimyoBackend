package com.company.service.ServiceImpl;

import com.company.dto.AnnouncementDtoGet;
import com.company.entity.Announcements;
import com.company.entity.AttachmentEntity;;
import com.company.payload.AnnouncementsDto;
import com.company.payload.ApiResponse;
import com.company.repository.AnnouncementRepository;
import com.company.repository.AttachmentRepository;
import com.company.repository.CategoryRepository;
import com.company.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    @Autowired
    private AttachmentRepository attachmentRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Value("${upload.server}")
    private String serverPath;

    @Override
    public ApiResponse announcementSave(AnnouncementsDto announcementsDto) {
        Announcements announcements=new Announcements();
        announcements.setDescriptionEN(announcementsDto.getDescriptionEN());
        announcements.setDescriptionKR(announcementsDto.getDescriptionKR());
        announcements.setDescriptionRU(announcementsDto.getDescriptionRU());
        announcements.setDescriptionUZ(announcementsDto.getDescriptionUZ());
        announcements.setShortdescriptionEN(announcementsDto.getShortdescriptionEN());
        announcements.setShortdescriptionKR(announcementsDto.getShortdescriptionKR());
        announcements.setShortdescriptionRU(announcementsDto.getShortdescriptionRU());
        announcements.setShortdescriptionUZ(announcementsDto.getShortdescriptionUZ());
        announcements.setTitleEN(announcementsDto.getTitleEN());
        announcements.setTitleRU(announcementsDto.getTitleRU());
        announcements.setTitleUZ(announcementsDto.getTitleUZ());
        announcements.setTitleKR(announcementsDto.getTitleKR());

        List<String> hashids=announcementsDto.getImages();
        List<AttachmentEntity> images=new ArrayList<>();

        for (String hashid : hashids) {
            Optional<AttachmentEntity> optional = attachmentRepository.findByHashId(hashid);
            if (optional.isPresent()){
                images.add(optional.get());
            }
        }
        announcements.setImages(images);
        announcementRepository.save(announcements);
        return new ApiResponse("add announcement success",true);
    }

    @Override
    public ApiResponse announcementEdit(Long id, AnnouncementsDto announcementsDto) {
        Optional<Announcements> optional = announcementRepository.findById(id);
        if (!optional.isPresent()){
            return new ApiResponse("not found announcement", false);
        }

        Announcements announcements = optional.get();
        announcements.setDescriptionEN(announcementsDto.getDescriptionEN());
        announcements.setDescriptionKR(announcementsDto.getDescriptionKR());
        announcements.setDescriptionRU(announcementsDto.getDescriptionRU());
        announcements.setDescriptionUZ(announcementsDto.getDescriptionUZ());
        announcements.setShortdescriptionEN(announcementsDto.getShortdescriptionEN());
        announcements.setShortdescriptionKR(announcementsDto.getShortdescriptionKR());
        announcements.setShortdescriptionRU(announcementsDto.getShortdescriptionRU());
        announcements.setShortdescriptionUZ(announcementsDto.getShortdescriptionUZ());
        announcements.setTitleEN(announcementsDto.getTitleEN());
        announcements.setTitleRU(announcementsDto.getTitleRU());
        announcements.setTitleUZ(announcementsDto.getTitleUZ());
        announcements.setTitleKR(announcementsDto.getTitleKR());

        List<String> hashids=announcementsDto.getImages();
        List<AttachmentEntity> images=new ArrayList<>();

        for (String hashid : hashids) {
            Optional<AttachmentEntity> optionalimages = attachmentRepository.findByHashId(hashid);
            if (optionalimages.isPresent()){
                images.add(optionalimages.get());
            }
        }
        announcements.setImages(images);

        announcementRepository.save(announcements);

        return new ApiResponse("edit announcement success",true);
    }

    @Override
    public ApiResponse announcementDelete(Long id) {
        try{
            announcementRepository.deleteById(id);
            return new ApiResponse("delete announcement",true);
        }catch (Exception e){
            return new ApiResponse("Error",false);
        }
    }

    @Override
    public AnnouncementDtoGet announcementGetById(Long id) {
        Optional<Announcements> optionalAnnouncements = announcementRepository.findById(id);
        if (!optionalAnnouncements.isPresent()){
            return null;
        }
        Announcements announcementsDto = optionalAnnouncements.get();
        AnnouncementDtoGet announcements=new AnnouncementDtoGet();

        announcements.setId(announcementsDto.getId());
        announcements.setDescriptionEN(announcementsDto.getDescriptionEN());
        announcements.setDescriptionKR(announcementsDto.getDescriptionKR());
        announcements.setDescriptionRU(announcementsDto.getDescriptionRU());
        announcements.setDescriptionUZ(announcementsDto.getDescriptionUZ());
        announcements.setShortdescriptionEN(announcementsDto.getShortdescriptionEN());
        announcements.setShortdescriptionKR(announcementsDto.getShortdescriptionKR());
        announcements.setShortdescriptionRU(announcementsDto.getShortdescriptionRU());
        announcements.setShortdescriptionUZ(announcementsDto.getShortdescriptionUZ());
        announcements.setTitleEN(announcementsDto.getTitleEN());
        announcements.setTitleRU(announcementsDto.getTitleRU());
        announcements.setTitleUZ(announcementsDto.getTitleUZ());
        announcements.setTitleKR(announcementsDto.getTitleKR());
        List<AttachmentEntity> images = announcementsDto.getImages();
        List<String> link=new ArrayList<>();
        for (AttachmentEntity image : images) {
            link.add(serverPath+image.getUploadFolder());
        }
        announcements.setImageslink(link);

        return announcements;
    }

    @Override
    public Page<AnnouncementDtoGet> allAnnouncement(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);

        List<Announcements> allByCategoryId = announcementRepository.findAll();
        List<AnnouncementDtoGet> announcementDtoGetList=new ArrayList<>();

        for (Announcements announcementsDto : allByCategoryId) {
            AnnouncementDtoGet announcements=new AnnouncementDtoGet();

            announcements.setId(announcementsDto.getId());
            announcements.setDescriptionEN(announcementsDto.getDescriptionEN());
            announcements.setDescriptionKR(announcementsDto.getDescriptionKR());
            announcements.setDescriptionRU(announcementsDto.getDescriptionRU());
            announcements.setDescriptionUZ(announcementsDto.getDescriptionUZ());
            announcements.setShortdescriptionEN(announcementsDto.getShortdescriptionEN());
            announcements.setShortdescriptionKR(announcementsDto.getShortdescriptionKR());
            announcements.setShortdescriptionRU(announcementsDto.getShortdescriptionRU());
            announcements.setShortdescriptionUZ(announcementsDto.getShortdescriptionUZ());
            announcements.setTitleEN(announcementsDto.getTitleEN());
            announcements.setTitleRU(announcementsDto.getTitleRU());
            announcements.setTitleUZ(announcementsDto.getTitleUZ());
            announcements.setTitleKR(announcementsDto.getTitleKR());
            List<AttachmentEntity> images = announcementsDto.getImages();
            List<String> link=new ArrayList<>();
            for (AttachmentEntity image : images) {
                link.add(serverPath+image.getUploadFolder());
            }
            announcements.setImageslink(link);

            announcementDtoGetList.add(announcements);
        }
        Page<AnnouncementDtoGet> announcementDtoGets=new PageImpl<>(announcementDtoGetList,pageable,announcementDtoGetList.size());
        return announcementDtoGets;
    }


}
