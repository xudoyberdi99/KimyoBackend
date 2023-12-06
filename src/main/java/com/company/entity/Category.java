package com.company.entity;

import com.company.entity.bace.BaceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent",orphanRemoval = true)
    @JsonIgnore
    private List<Category> subCategories = new ArrayList<>();
}
