package com.company.entity;

import com.company.entity.bace.BaceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "center_departments")
public class CenterAndDepartments extends BaceEntity {
    private String nameUZ;
    private String nameRU;
    private String nameEN;
    private String nameKR;

    private String titleUZ;
    private String titleRU;
    private String titleEN;
    private String titleKR;

    private String descriptionUZ;
    private String descriptionRU;
    private String descriptionEN;
    private String descriptionKR;

    @OneToMany(mappedBy = "centerAndDepartments")
    private List<CenterAndDepartmentsEmployees> employees;
}
