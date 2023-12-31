package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
public class FacultyDto {
    @NotBlank(message = "please provide a Faculty name")
    private String nameUZ;
    @NotBlank(message = "please provide a Faculty name")
    private String nameRU;
    @NotBlank(message = "please provide a Faculty name")
    private String nameEN;
    @NotBlank(message = "please provide a Faculty name")
    private String nameKR;

    private String titleUZ;

    private String titleRU;

    private String titleEN;

    private String titleKR;

    private String DescriptionUZ;
    private String DescriptionRU;
    private String DescriptionEN;
    private String DescriptionKR;

    private Long leadershipId;
}
