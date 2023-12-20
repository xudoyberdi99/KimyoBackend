package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "news_day")
public class NewsDay extends BaceEntity {

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String titleUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String titleRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String titleEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String titleKR;

    @Lob
    @Column(columnDefinition="TEXT")
    private String shortdescriptionUZ;

    @Lob
    @Column(columnDefinition="TEXT")
    private String shortdescriptionRU;

    @Lob
    @Column(columnDefinition="TEXT")
    private String shortdescriptionEN;

    @Lob
    @Column(columnDefinition="TEXT")
    private String shortdescriptionKR;

    @Lob
    @Column(columnDefinition="TEXT")
    private String descriptionUZ;

    @Lob
    @Column(columnDefinition="TEXT")
    private String descriptionRU;

    @Lob
    @Column(columnDefinition="TEXT")
    private String descriptionEN;

    @Lob
    @Column(columnDefinition="TEXT")
    private String descriptionKR;

    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private AttachmentEntity images;
}
