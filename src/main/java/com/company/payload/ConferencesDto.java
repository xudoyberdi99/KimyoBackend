package com.company.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ConferencesDto {
    @NotBlank(message = "please provide a sana")
    private String sana;
    @NotBlank(message = "please provide a phone")
    private String phone;
    @NotBlank(message = "please provide a email")
    private String email;
    @NotBlank(message = "please provide a address")
    private String address;


    @NotBlank(message="Please provide a descriptionUZ" )
    private String descriptionUZ;
    @NotBlank(message="Please provide a descriptionRU" )
    private String descriptionRU;
    @NotBlank(message="Please provide a descriptionEN" )
    private String descriptionEN;
    @NotBlank(message="Please provide a descriptionKR" )
    private String descriptionKR;
    @NotNull
    private Long categoryId;
}
