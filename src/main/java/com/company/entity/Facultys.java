package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "facultys")
public class Facultys extends BaceEntity {

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
}
