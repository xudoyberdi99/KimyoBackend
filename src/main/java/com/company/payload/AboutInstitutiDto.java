package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
public class AboutInstitutiDto {

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
    @NotBlank(message = "please provide a images")
    private List<String> images;
}
