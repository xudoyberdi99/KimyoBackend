package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "openData")
public class OpenData extends BaceEntity {

    @Column(nullable = false)
    private String nameUZ;
    @Column(nullable = false)
    private String nameRU;
    @Column(nullable = false)
    private String nameEN;
    @Column(nullable = false)
    private String nameKR;

    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private AttachmentEntity attachment;
}
