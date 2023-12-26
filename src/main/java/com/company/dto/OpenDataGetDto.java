package com.company.dto;

import lombok.Data;

@Data
public class OpenDataGetDto {
    private Long id;

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private AttachDto file;
}
