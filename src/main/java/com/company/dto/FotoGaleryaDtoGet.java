package com.company.dto;

import lombok.Data;

@Data
public class FotoGaleryaDtoGet {
    private Long id;

    private AttachDto images;

    private String titleUZ;

    private String titleRU;

    private String titleEN;

    private String titleKR;
}
