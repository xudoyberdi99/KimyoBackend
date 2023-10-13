package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "interactive_service")
public class InteraktivService extends BaceEntity {

    private String link;

    private String nameUZ;

    private String nameRU;

    private String nameEN;

    private String nameKR;

    private String descriptionUZ;

    private String descriptionRU;

    private String descriptionEN;

    private String descriptionKR;

    @OneToOne
    private AttachmentEntity icon;
}
