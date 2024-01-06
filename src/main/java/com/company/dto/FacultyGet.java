package com.company.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FacultyGet {
    private Long id;

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String titleUZ;

    private String titleRU;

    private String titleEN;

    private String titleKR;

    private String DescriptionUZ;
    private String DescriptionRU;
    private String DescriptionEN;
    private String DescriptionKR;

    private LeadershipGet leadership;
}
