package com.company.entity;

import com.company.entity.bace.BaceEntity;
import com.company.entity.enums.FileEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "attachment")
public class AttachmentEntity extends BaceEntity {

    private String orginalName;

    private String contentType;

    private Long fileSize;

    private String extension;

    private String hashId;

    private FileEnum fileEnum;

    private String uploadFolder;

}
