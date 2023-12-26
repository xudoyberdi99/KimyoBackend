package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
public class OpenDataDto {

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String hashId;
}
