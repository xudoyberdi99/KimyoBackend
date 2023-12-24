package com.company.payload;

import lombok.Data;

@Data
public class RegulatoryDocumentsDto {
    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;

    private String hashId;
}
