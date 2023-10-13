package com.company.entity;

import com.company.entity.bace.BaceEntity;
import com.company.entity.enums.FileEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

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
