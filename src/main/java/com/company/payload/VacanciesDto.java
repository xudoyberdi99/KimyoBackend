package com.company.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Data
public class VacanciesDto {

    @NotNull(message = "iltimos vakansiya nomini kiriting")
    private String nameUZ;
    @NotNull(message = "iltimos vakansiya nomini kiriting")
    private String nameRU;
    @NotNull(message = "iltimos vakansiya nomini kiriting")
    private String nameEN;
    @NotNull(message = "iltimos vakansiya nomini kiriting")
    private String nameKR;

    private String salary;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;
}
