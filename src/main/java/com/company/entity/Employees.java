package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

    private String telegramlink;
    private String facebooklink;
    private String instagramlink;
    private String twitterlink;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String biography;

    @OneToMany
    private List<AttachmentEntity> loyhalar;

    @OneToOne(optional = false)
    private AttachmentEntity  image;
}
