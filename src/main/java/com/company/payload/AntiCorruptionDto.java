package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

@Data
public class AntiCorruptionDto {

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;

    private String  hashId;

}
