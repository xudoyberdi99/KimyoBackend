package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "category")
public class Category extends BaceEntity {

    @Column(nullable = false, unique = true)
    private String nameUZ;
    @Column(nullable = false, unique = true)
    private String nameRU;
    @Column(nullable = false, unique = true)
    private String nameEN;
    @Column(nullable = false, unique = true)
    private String nameKR;

    @ManyToOne
    private Category parent;

}
