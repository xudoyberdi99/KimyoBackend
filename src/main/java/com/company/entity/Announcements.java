package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.List;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "announcements")
public class Announcements extends BaceEntity {

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
    private List<AttachmentEntity> images;
}
