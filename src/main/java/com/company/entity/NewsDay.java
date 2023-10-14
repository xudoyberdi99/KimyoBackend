package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "news_day")
public class NewsDay extends BaceEntity {
    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String titleUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String titleRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String titleEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String titleKR;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String shortdescriptionUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String shortdescriptionRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String shortdescriptionEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String shortdescriptionKR;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760)
    private String descriptionKR;

    @OneToOne
    private AttachmentEntity images;




}
