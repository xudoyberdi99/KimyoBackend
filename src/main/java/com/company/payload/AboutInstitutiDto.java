package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Data
public class AboutInstitutiDto {

    private String titleUZ;

    private String titleRU;

    private String titleEN;

    private String titleKR;

    private String shortdescriptionUZ;

    private String shortdescriptionRU;

    private String shortdescriptionEN;

    private String shortdescriptionKR;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;

    private List<String> images;
}
