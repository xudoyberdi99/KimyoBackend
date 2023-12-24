package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Data
public class FotoGaleriyaDto {

    private String hashId;

    private String titleUZ;

    private String titleRU;

    private String titleEN;

    private String titleKR;
}
