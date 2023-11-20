package com.company.payload;

import com.company.entity.Leadership;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
public class DepartmentsDto {
    @NotBlank(message = "Iltimos Kafedra nomini kiriting")
    private String nameUZ;
    @NotBlank(message = "Iltimos Kafedra nomini kiriting")
    private String nameRU;
    @NotBlank(message = "Iltimos Kafedra nomini kiriting")
    private String nameEN;
    @NotBlank(message = "Iltimos Kafedra nomini kiriting")
    private String nameKR;

    @NotBlank(message = "Kafedra Tarixi Majburiy kiritish")
    private String DescriptionUZ;
    @NotBlank(message = "Kafedra Tarixi Majburiy kiritish")
    private String DescriptionRU;
    @NotBlank(message = "Kafedra Tarixi Majburiy kiritish")
    private String DescriptionEN;
    @NotBlank(message = "Kafedra Tarixi Majburiy kiritish")
    private String DescriptionKR;


    private Long  leadershipId;

}
