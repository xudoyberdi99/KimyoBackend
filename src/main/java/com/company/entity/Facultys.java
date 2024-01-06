package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "facultys")
public class Facultys extends BaceEntity {

    @Column(nullable = false)
    private String nameUZ;
    @Column(nullable = false)
    private String nameRU;
    @Column(nullable = false)
    private String nameEN;
    @Column(nullable = false)
    private String nameKR;
    @Column(nullable = false)
    private String titleUZ;
    @Column(nullable = false)
    private String titleRU;
    @Column(nullable = false)
    private String titleEN;
    @Column(nullable = false)
    private String titleKR;
    @Column(nullable = false)
    private String DescriptionUZ;
    @Column(nullable = false)
    private String DescriptionRU;
    @Column(nullable = false)
    private String DescriptionEN;
    @Column(nullable = false)
    private String DescriptionKR;

    @OneToOne(optional = false,cascade = CascadeType.REMOVE)
    private Leadership leadership;

}
