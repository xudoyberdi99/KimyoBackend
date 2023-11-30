package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "generalPage")
public class GeneralPage extends BaceEntity {

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionKR;
    private String descriptionEN;

    @ManyToOne(optional = false)
    private Category category;
}
