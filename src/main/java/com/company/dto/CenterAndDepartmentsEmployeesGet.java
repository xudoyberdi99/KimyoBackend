package com.company.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CenterAndDepartmentsEmployeesGet {
    private Long id;
    private String fullName;

    private String degree;


    private String phoneNumber;


    private String email;

    private String Fax;

    private String telegramlink;
    private String facebooklink;
    private String instagramlink;
    private String twitterlink;


    private String biographyUZ;


    private String biographyRU;


    private String biographyEN;


    private String biographyKR;


    private String dutiesUZ;

    private String dutiesRU;

    private String dutiesEN;

    private String dutiesKR;

    private AttachDto file;

    private Long centerAndDepartmentId;
}
