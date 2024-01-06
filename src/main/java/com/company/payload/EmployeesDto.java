package com.company.payload;

import com.company.entity.AttachmentEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Data
public class EmployeesDto {

    @NotBlank(message = "Iltimos Fullnameni kiriting")
    private String fullName;

    private String degree;

    @NotBlank(message = "Iltimos phoneNumberni kiriting")
    private String phoneNumber;

    @NotBlank(message = "Iltimos phone Numberni kiriting")
    private String email;

    private String Fax;

    private String telegramlink;
    private String facebooklink;
    private String instagramlink;
    private String twitterlink;

    @NotBlank(message = "Iltimos Biografiyani tuldiring")
    private String biographyUZ;

    @NotBlank(message = "Iltimos Biografiyani tuldiring")
    private String biographyRU;

    @NotBlank(message = "Iltimos Biografiyani tuldiring")
    private String biographyEN;

    @NotBlank(message = "Iltimos Biografiyani tuldiring")
    private String biographyKR;


    private String dutiesUZ;

    private String dutiesRU;

    private String dutiesEN;

    private String dutiesKR;



    private String hashid;

    private Long departmentid;



}
