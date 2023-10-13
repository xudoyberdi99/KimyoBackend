package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "About")
public class AboutInstituti extends BaceEntity {

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

    @OneToMany
    private Set<AttachmentEntity> images;
}
