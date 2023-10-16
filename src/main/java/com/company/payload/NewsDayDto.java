package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
public class NewsDayDto {

    @NotBlank(message="Please provide a titleUZ" )
    private String titleUZ;
    @NotBlank(message="Please provide a titleRU" )
    private String titleRU;
    @NotBlank(message="Please provide a titleEN" )
    private String titleEN;
    @NotBlank(message="Please provide a titleKR" )
    private String titleKR;
    @NotBlank(message="Please provide a shortdescriptionUZ" )
    private String shortdescriptionUZ;
    @NotBlank(message="Please provide a shortdescriptionRU" )
    private String shortdescriptionRU;
    @NotBlank(message="Please provide a shortdescriptionEN" )
    private String shortdescriptionEN;
    @NotBlank(message="Please provide a shortdescriptionKR" )
    private String shortdescriptionKR;
    @NotBlank(message="Please provide a descriptionUZ" )
    private String descriptionUZ;
    @NotBlank(message="Please provide a descriptionRU" )
    private String descriptionRU;
    @NotBlank(message="Please provide a descriptionEN" )
    private String descriptionEN;
    @NotBlank(message="Please provide a descriptionKR" )
    private String descriptionKR;

    private String hashId;
}
