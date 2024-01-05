package com.company.dto;

import lombok.Data;

@Data
public class AntiCorruptionDtoGet {
    private Long id;

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;

    private AttachDto file;
}
