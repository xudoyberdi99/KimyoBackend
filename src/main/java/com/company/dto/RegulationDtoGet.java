package com.company.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RegulationDtoGet {

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;

    private Timestamp createdDate;

    private AttachDto file;
}
