package com.company.payload;

import com.company.entity.AttachmentEntity;
import com.company.entity.enums.LeadershipStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
public class LeadershipDto {

    @NotBlank(message = "Please enter your full name")
    private String fullName;

    private String degree;

    @NotBlank(message = "Please enter your phoneNumber")
    private String phoneNumber;
    @NotBlank(message = "Please enter your email")
    private String email;

    private String Fax;
    private String telegramlink;
    private String facebooklink;
    private String instagramlink;
    private String twitterlink;

    @NotBlank(message = "Please enter your biography")
    private String biographyUZ;

    @NotBlank(message = "Please enter your biography")
    private String biographyRU;

    @NotBlank(message = "Please enter your biography")
    private String biographyEN;

    @NotBlank(message = "Please enter your biography")
    private String biographyKR;


    private String dutiesUZ;

    private String dutiesRU;

    private String dutiesEN;

    private String dutiesKR;


    @NotBlank(message = "Please enter hashid")
    private String hashId;


    private String leadershipStatus;
}
