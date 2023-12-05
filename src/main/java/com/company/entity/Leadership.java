package com.company.entity;

import com.company.entity.bace.BaceEntity;
import com.company.entity.enums.LeadershipStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "leadership")
public class Leadership extends BaceEntity {
    @Column(nullable = false)
    private String fullName;

    private String degree;

    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false,unique = true)
    @Email
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
    @Column(columnDefinition="TEXT", length=10485760)
    private String dutiesUZ;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String dutiesRU;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String dutiesEN;
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String dutiesKR;


    @OneToOne(optional = false)
    private AttachmentEntity  image;

    @Enumerated(EnumType.STRING)
    private LeadershipStatus leadershipStatus;

    @ManyToOne
    private Category category;
}
