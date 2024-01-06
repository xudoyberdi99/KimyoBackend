package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "employees")
public class Employees extends BaceEntity {

    @Column(nullable = false)
    private String fullName;

    private String degree;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    private String Fax;
    private String telegramlink;
    private String facebooklink;
    private String instagramlink;
    private String twitterlink;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String biographyUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String biographyRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String biographyEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String biographyKR;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String dutiesUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String dutiesRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String dutiesEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String dutiesKR;


    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private AttachmentEntity  image;

    @ManyToOne(optional = false)
    private Departments departments;

}
