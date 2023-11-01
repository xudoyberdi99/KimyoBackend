package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
public class InteraktivServiceDto {
    @NotBlank(message = "please provide a link")
    private String link;

    @NotBlank(message="Please provide a titleUZ" )
    private String nameUZ;
    @NotBlank(message="Please provide a titleRU" )
    private String nameRU;
    @NotBlank(message="Please provide a titleEN" )
    private String nameEN;
    @NotBlank(message="Please provide a titleKR" )
    private String nameKR;

    @NotBlank(message="Please provide a descriptionUZ" )
    private String descriptionUZ;
    @NotBlank(message="Please provide a descriptionRU" )
    private String descriptionRU;
    @NotBlank(message="Please provide a descriptionEN" )
    private String descriptionEN;
    @NotBlank(message="Please provide a descriptionKR" )
    private String descriptionKR;
    @NotBlank(message = "please provide a images")
    private String  icon;
}
