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
@Entity(name = "foto_galeriya")
public class FotoGaleriya extends BaceEntity {

    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private AttachmentEntity hashId;


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
}
