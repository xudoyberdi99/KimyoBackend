package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "departments")
public class Departments extends BaceEntity {
    private String nameUZ;
    private String nameRU;
    private String nameEN;
    private String nameKR;


    private String DescriptionUZ;
    private String DescriptionRU;
    private String DescriptionEN;
    private String DescriptionKR;

    @OneToOne(optional = false)
    private Leadership leadership;

    @ManyToOne(optional = false)
    private Facultys facultys;

    @ManyToOne
    private Category category;
}
