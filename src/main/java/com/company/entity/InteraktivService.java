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
@Entity(name = "interactive_service")
public class InteraktivService extends BaceEntity {
    @Column(nullable = false)
    private String link;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String nameUZ;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String nameRU;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String nameEN;

    @Lob
    @Column(columnDefinition="TEXT", length=10485760, nullable = false)
    private String nameKR;

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

    @OneToOne(optional = false)
    private AttachmentEntity icon;
}
