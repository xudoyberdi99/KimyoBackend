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
@Entity(name = "announcements")
public class Announcements extends BaceEntity {

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

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<AttachmentEntity> images;

}
