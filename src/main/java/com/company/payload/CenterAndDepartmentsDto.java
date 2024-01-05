package com.company.payload;

import lombok.Data;

@Data
public class CenterAndDepartmentsDto {
    private String nameUZ;
    private String nameRU;
    private String nameEN;
    private String nameKR;

    private String titleUZ;
    private String titleRU;
    private String titleEN;
    private String titleKR;

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionEN;
    private String descriptionKR;
}
